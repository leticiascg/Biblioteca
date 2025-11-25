package com.example.resumo.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.HashMap;
import java.util.Map;


@Service
public class GeminiService {


    @Value("${gemini.api.key}")
    private String apiKey;


    @Value("${gemini.model}")
    private String model;


    private final ObjectMapper objectMapper = new ObjectMapper();


    public String summarize(String text) {
        try {
            RestTemplate rest = new RestTemplate();


            String url = String.format("https://generativelanguage.googleapis.com/v1beta/models/%s:generateContent", model);


            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.add("x-goog-api-key", apiKey);


            String prompt = "Resuma o texto abaixo em um parágrafo curto e claro:\n" + text;


            Map<String, Object> contentPart = new HashMap<>();
            contentPart.put("text", prompt);


            Map<String, Object> part = new HashMap<>();
            part.put("parts", new Object[]{contentPart});


            Map<String, Object> body = new HashMap<>();
            body.put("contents", new Object[]{part});


            String bodyStr = objectMapper.writeValueAsString(body);


            HttpEntity<String> request = new HttpEntity<>(bodyStr, headers);


            String response = rest.postForObject(url, request, String.class);


            if (response == null) return "Erro: resposta vazia da API";


            JsonNode root = objectMapper.readTree(response);
            JsonNode textNode = root.path("candidates").path(0).path("content").path("parts").path(0).path("text");
            if (textNode.isMissingNode() || textNode.isNull()) {
                return "Erro: não foi possível extrair o texto da resposta da API" + "\n\n" + response;
            }


            String raw = textNode.asText();
            raw = raw.replaceAll("(?s)```json.*?```", "");
            raw = raw.replaceAll("```", "");


            return raw.trim();


        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao chamar Gemini: " + e.getMessage();
        }
    }
}