package com.suporte.SiteWebSuporte.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // Fala para o Hibernate criar uma tabela dessa classe
public class Procedimento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long id_procedimento;
    private String nome;
    private String categoria;
    
    @Column(columnDefinition = "TEXT") // * Define o tipo text para a coluna texto */
    private String texto;

    /**
     * @return long return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return long return the id_procedimento
     */
    public long getId_procedimento() {
        return id_procedimento;
    }

    /**
     * @param id_procedimento the id_procedimento to set
     */
    public void setId_procedimento(long id_procedimento) {
        this.id_procedimento = id_procedimento;
    }

    /**
     * @return String return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return String return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * @return String return the texto
     */

    public String getTexto() {
        return texto;
    }

    /**
     * @param texto the texto to set
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }

}
