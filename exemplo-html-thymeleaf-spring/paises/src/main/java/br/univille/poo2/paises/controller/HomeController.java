package br.univille.poo2.paises.controller;

import br.univille.poo2.paises.service.PaisService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {

    private final PaisService paisService;

    public HomeController(PaisService paisService) {
        this.paisService = paisService;
    }

    // Mapeia a url raiz para o arquivo html home.html
    // GET
    @GetMapping
    public String home() {
        // Retorna o nome do arquivo html
        // resources/templates/home.html
        return "index";
    }

    @GetMapping
    @RequestMapping("/criar-paises")
    public ModelAndView criarPaises() {
        paisService.adicionarPaises();
        // Redireciona para a url raiz
        return new ModelAndView("redirect:/paises2");
    }

    @GetMapping
    @RequestMapping("/deletar-paises")
    public ModelAndView deletarPaises() {
        paisService.deletarTudo();
        // Redireciona para a url raiz
        return new ModelAndView("redirect:/paises2");
    }

}
