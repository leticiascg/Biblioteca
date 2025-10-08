package br.univille.poo2.paises.repository;

import br.univille.poo2.paises.entity.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Classe responsável por manipular os dados do banco de dados
 * Consultas (com filtros), inserções/updates e deleção
 */
public interface PaisRepository extends JpaRepository<Pais,Long> {
}
