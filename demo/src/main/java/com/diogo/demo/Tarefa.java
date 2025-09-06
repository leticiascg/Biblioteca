package com.diogo.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private boolean finalizada;
    private LocalDate dataCriacao;
    private LocalDate dataFinalizacao;
    private LocalDate dataPrevFin;

    public Tarefa() {
    }

    public Tarefa(Long id, String descricao, boolean finalizada, LocalDate dataCriacao, LocalDate dataFinalizacao, LocalDate dataPrevFin) {
        this.id = id;
        this.descricao = descricao;
        this.finalizada = (dataFinalizacao != null) &&
                (dataFinalizacao.isEqual(dataCriacao) || dataFinalizacao.isAfter(dataCriacao));

        this.dataCriacao = dataCriacao;
        this.dataFinalizacao = dataFinalizacao;
        this.dataPrevFin = dataPrevFin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isFinalizada() {
        return finalizada;
    }

    public void setFinalizada(boolean finalizada) {
        this.finalizada = finalizada;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getDataFinalizacao() {
        return dataFinalizacao;
    }

    public void setDataFinalizacao(LocalDate dataFinalizacao) {
        this.dataFinalizacao = dataFinalizacao;
    }

    public LocalDate getDataPrevFin() {
        return dataPrevFin;
    }

    public void setDataPrevFin(LocalDate dataPrevFin) {
        this.dataPrevFin = dataPrevFin;
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", finalizada=" + finalizada +
                ", dataCriacao=" + dataCriacao +
                ", dataFinalizacao=" + dataFinalizacao +
                ", dataPrevFin=" + dataPrevFin +
                '}';
    }
}
