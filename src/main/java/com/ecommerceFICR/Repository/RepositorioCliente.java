package com.ecommerceFICR.Repository;

import com.ecommerceFICR.Interface.CadastroCliente;
import com.ecommerceFICR.Model.clientes.Cliente;

import java.util.ArrayList;
import java.util.List;

public class RepositorioCliente implements CadastroCliente {
    private List<Cliente> clientes;

    public RepositorioCliente() {
        this.clientes = new ArrayList<>();
    }

    @Override
    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }


    @Override
    public Cliente buscarClientePorId(int idCliente) {
        for (Cliente cliente : clientes) {
            if (cliente.getIdCliente() == idCliente) {
                return cliente;
            }
        }
        return null;
    }

    @Override
    public void atualizarCliente(Cliente clienteAtualizado) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getIdCliente() == clienteAtualizado.getIdCliente()) {
                clientes.set(i, clienteAtualizado);
                return;
            }
        }
    }

    @Override
    public void removerCliente(int idCliente) {
        clientes.removeIf(cliente -> cliente.getIdCliente() == idCliente);
    }

    @Override
    public List<Cliente> listarTodos() {
        return new ArrayList<>(clientes);
    }
}