package com.diogo.demo;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class DemoApplication {

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
		SpringApplication.run(DemoApplication.class, args);
	}

	//Long id, String descricao, boolean finalizada, LocalDateTime dataCriacao,
	// LocalDateTime dataFinalizacao, LocalDateTime dataPrevFin

	@Bean
	CommandLineRunner runn(TarefaRepository repos) {
		return args -> {
			// Inserções
			repos.save(new Tarefa(null,"Insert",false, LocalDate.of(2025,01,06),LocalDate.of(2025,01,19),LocalDate.of(2025,01,10)));

			// Select
			System.out.println("Lista de Tarefas:");
			repos.findAll().forEach(p ->
					System.out.println(p.getId() + " - " + p.getDataCriacao() + " " + p.getDescricao())
			);
		};
	}
}