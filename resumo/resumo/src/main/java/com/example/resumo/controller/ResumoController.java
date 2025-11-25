    package com.example.resumo.controller;


    import com.example.resumo.service.GeminiService;
    import jakarta.validation.constraints.NotBlank;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.validation.annotation.Validated;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestParam;


    @Controller
    @Validated
    public class ResumoController {


        private final GeminiService geminiService;


        public ResumoController(GeminiService geminiService) {
            this.geminiService = geminiService;
        }


        @GetMapping("/")
        public String index() {
            return "index";
        }


        @PostMapping("/summarize")
        public String summarize(@RequestParam("text") @NotBlank String text, Model model) {
            String summary = geminiService.summarize(text);
            model.addAttribute("original", text);
            model.addAttribute("summary", summary);
            return "result";
        }
    }