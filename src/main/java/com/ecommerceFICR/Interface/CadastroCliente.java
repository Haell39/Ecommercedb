package com.ecommerceFICR.Interface;

import com.ecommerceFICR.Model.clientes.Cliente;
import java.util.List;

public interface CadastroCliente {
    void cadastrarCliente(Cliente cliente);
    Cliente buscarClientePorId(int idCliente);
    void atualizarCliente(Cliente cliente);
    void removerCliente(int idCliente);
    List<Cliente> listarTodos();
}