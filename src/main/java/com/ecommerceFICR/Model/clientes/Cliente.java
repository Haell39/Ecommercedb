package com.ecommerceFICR.Model.clientes;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public abstract class Cliente {

    @Id
    private Integer idCliente;
    private String nome;
    private String cpf;
    private String endereco;
    private String email;

    // Construtor sem parâmetros
    public Cliente() {
    }

    // Construtor com parâmetros
    public Cliente(Integer idCliente, String nome, String cpf, String endereco, String email) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.email = email;
    }

    // Getters e Setters
    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public abstract void registrarCompra(double valor);
}
