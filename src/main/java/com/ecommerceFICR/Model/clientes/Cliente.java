package com.ecommerceFICR.Model.clientes;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Cliente {
    @Id
    private int idCliente;
    private String nome;
    private String cpf;
    private String endereco;
    private String email;

    // Construtor
    public Cliente(int idCliente, String nome, String cpf, String endereco, String email) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.email = email;
    }

    // Getters e Setters
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Método abstrato removido
    public void registrarCompra(double valor) {
        // Implemente a lógica de compra aqui, se necessário
    }

    @Override
    public String toString() {
        return "Cliente ID: " + idCliente + ", Nome: " + nome + ", CPF: " + cpf + ", Endereço: " + endereco + ", Email: " + email;
    }
}
