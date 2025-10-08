package br.univille.poo2.paises.controller;

import br.univille.poo2.paises.entity.Pais;
import br.univille.poo2.paises.service.PaisService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Classe responsável por lidar com as requisições HTTP
 * A classe deve chamar o service para alguma lógica de negócio.
 * Nunca acesse Repository diretamente.
 */
@Controller
@RequestMapping("/paises2")
public class PaisDinamicoController {


    //@Autowired -> Evite utilizar injeção via atributo
    // use via construtor
    private final PaisService paisService;

    /**
     * Injeção de dependencia via construtor
     * @param paisService
     */
    public PaisDinamicoController(PaisService paisService) {
        this.paisService = paisService;
    }

    @GetMapping
    public ModelAndView index() {
        var mv = new ModelAndView("pais/lista_dinamica");
        var lista = paisService.findAll();
        // Adiciona a lista de paises na view com o nome 'paises'
        mv.addObject("paises", lista);
        return mv;
    }

    @GetMapping
    @RequestMapping("/aleatorio")
    public ModelAndView aleatorio() {
        var optional = paisService.obterUmPaisAleatoriamente();
        // Caso não exista países cadastrados, retorna uma mensagem de erro
        if(optional.isEmpty()){
            return new ModelAndView("pais/nao_ha_paises");
        }
        // Adiciona o objeto pais na view com o nome 'pais'
        var mv = new ModelAndView("pais/pais_aleatorio");
        mv.addObject("pais", optional.get());
        return mv;
    }



}
