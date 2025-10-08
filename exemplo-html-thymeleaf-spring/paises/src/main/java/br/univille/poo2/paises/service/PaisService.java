package br.univille.poo2.paises.service;

import br.univille.poo2.paises.entity.Pais;
import br.univille.poo2.paises.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Classe responsável por toda lógica de negócios
 * Esta classe que deve acessar o banco de dados via Repository
 */
@Service
public class PaisService {

    private final PaisRepository paisRepository;

    public PaisService(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    public List<Pais> findAll() {
        return paisRepository.findAll();
    }

    public void adicionarPaises(){
        var pais = new Pais();
        pais.setNome("Argentina");
        pais.setCapital("Buenos Aires");
        pais.setContinente("America do Sul");
        pais.setBandeiraUrl("https://upload.wikimedia.org/wikipedia/commons/1/1a/Flag_of_Argentina.svg");
        paisRepository.save(pais);
        pais = new Pais();
        pais.setNome("Brasil");
        pais.setCapital("Brasília");
        pais.setContinente("América do Sul");
        pais.setBandeiraUrl("https://upload.wikimedia.org/wikipedia/commons/0/05/Flag_of_Brazil.svg");
        paisRepository.save(pais);

        pais = new Pais();
        pais.setNome("Canadá");
        pais.setCapital("Montreal");
        pais.setContinente("América do Norte");
        pais.setBandeiraUrl("https://upload.wikimedia.org/wikipedia/commons/d/d9/Flag_of_Canada_%28Pantone%29.svg");
        paisRepository.save(pais);

        pais = new Pais();
        pais.setNome("Dinamarca");
        pais.setCapital("Copenhague");
        pais.setContinente("Europa");
        pais.setBandeiraUrl("https://upload.wikimedia.org/wikipedia/commons/9/9c/Flag_of_Denmark.svg");
        paisRepository.save(pais);

        pais = new Pais();
        pais.setNome("Escócia");
        pais.setCapital("Edimburgo");
        pais.setContinente("Europa");
        pais.setBandeiraUrl("https://upload.wikimedia.org/wikipedia/commons/1/10/Flag_of_Scotland.svg");
        paisRepository.save(pais);

        pais = new Pais();
        pais.setNome("Filipinas");
        pais.setCapital("Manila");
        pais.setContinente("Ásia");
        pais.setBandeiraUrl("https://upload.wikimedia.org/wikipedia/commons/9/99/Flag_of_the_Philippines.svg");
        paisRepository.save(pais);

        pais = new Pais();
        pais.setNome("Gabão");
        pais.setCapital("Libreville");
        pais.setContinente("África");
        pais.setBandeiraUrl("https://upload.wikimedia.org/wikipedia/commons/0/04/Flag_of_Gabon.svg");
        paisRepository.save(pais);

    }

    public void deletarTudo(){
        paisRepository.deleteAll();
    }

    /**
     * Consulta todos os países e escolhe um aleatoriamente
     * Caso não possuir países cadastrados, ele retorna um Optional.empty()
     * @return
     */
    public Optional<Pais> obterUmPaisAleatoriamente() {
        var lista = findAll();
        if(lista.isEmpty()){ return Optional.empty();}
        return Optional.ofNullable(lista.get((int) (Math.random() * lista.size())));
    }
}
