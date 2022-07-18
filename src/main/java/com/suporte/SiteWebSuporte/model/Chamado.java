package com.suporte.SiteWebSuporte.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Chamado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String categoria;
    private String descricao;

    private String numeroChamado;
    private String procedimentoUsado;
    @Column(columnDefinition = "TEXT")
    private String procedimentosFeito;
    private String statusChamado;
    private String dataChamado;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNumeroChamado() {
        return this.numeroChamado;
    }

    public void setNumeroChamado(String numeroChamado) {
        this.numeroChamado = numeroChamado;
    }

    public String getProcedimentoUsado() {
        return this.procedimentoUsado;
    }

    public void setProcedimentoUsado(String procedimentoUsado) {
        this.procedimentoUsado = procedimentoUsado;
    }

    public String getProcedimentosFeito() {
        return this.procedimentosFeito;
    }

    public void setProcedimentosFeito(String procedimentosFeito) {
        this.procedimentosFeito = procedimentosFeito;
    }

    public String getStatusChamado() {
        return this.statusChamado;
    }

    public void setStatusChamado(String statusChamado) {
        this.statusChamado = statusChamado;
    }

    public Chamado orElseThrow(Object object) {
        return null;
    }

}
