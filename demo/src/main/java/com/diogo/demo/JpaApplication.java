package com.diogo.demo;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class JpaApplication {

//	@Bean
//	CommandLineRunner run(PessoaRepository repo) {
//		return args -> {
//			// Inserções
//			repo.save(new Pessoa(null, "João", "Silva"));
//			repo.save(new Pessoa(null, "Maria", "Oliveira"));
//
//			// Select
//			System.out.println("Lista de pessoas:");
//			repo.findAll().forEach(p ->
//					System.out.println(p.getId() + " - " + p.getNome() + " " + p.getSobrenome())
//			);
//		};
//	}

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	//Long id, String descricao, boolean finalizada, LocalDateTime dataCriacao,
	// LocalDateTime dataFinalizacao, LocalDateTime dataPrevFin

	@Bean
	CommandLineRunner runn(TarefaRepository repos) {
		return args -> {
			// Inserções
			//repos.save(new Tarefa(null,"Insert",false, LocalDate.of(2025,01,06),LocalDate.of(2025,01,19),LocalDate.of(2025,01,10)));
			//repos.save(new Tarefa(null,"Exercicio POO 1",true,LocalDate.of(2025,9,8),LocalDate.of(2025,9,10),LocalDate.of(2025,9,9)));
			//repos.save(new Tarefa(null,"Exercio TEST 1",false,LocalDate.of(2025,9,1),LocalDate.of(2025,9,2),LocalDate.of(2025,9,5)));
			// Select

			System.out.println("Tarefas não finalizadas:");
			repos.findByFinalizadaFalse().forEach(nao-> System.out.println("[ "+nao.getId()+" ] "+nao.getDescricao()+" - "+ nao.getDataCriacao()+" - "+nao.getDataPrevFin()));
			System.out.println("Lista de Tarefas:");
			repos.findAll().forEach(p ->
					System.out.println(p.getId() + " - " + p.getDataCriacao() + " " + p.getDescricao()));

			System.out.println();
			System.out.println("Tarefas realizadas após a data prevista");
			System.out.println("---------------------------------------");
			repos.findTarefasEntreguesAtrasados().forEach(ap->
					System.out.println("[ "+ ap.getId()+" ] "+ ap.getDescricao()));
		};
	}



}