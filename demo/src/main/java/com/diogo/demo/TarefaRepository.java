package com.diogo.demo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa,Long> {
    //procurando tarefas nao finalizadas
    public List<Tarefa> findByFinalizadaFalse();

    //procurando tarefas que terminaram apos a data de previsao
    public List<Tarefa> findByDataPrevFinLessThenDataFinalizacao();
}
