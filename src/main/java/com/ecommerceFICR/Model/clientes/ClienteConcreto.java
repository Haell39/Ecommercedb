package com.ecommerceFICR.Model.clientes;

public class ClienteConcreto extends Cliente {

    public ClienteConcreto() {
        // Construtor sem parâmetros
    }

    public ClienteConcreto(int idCliente, String nome, String cpf, String endereco, String email) {
        super(idCliente, nome, cpf, endereco, email);
    }

    @Override
    public void registrarCompra(double valor) {
        // Lógica de registrar compra
    }
}
