package br.com.acto.vendinha.entity;

import br.com.acto.vendinha.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClientEntity extends GenericEntity<Cliente>{
    public List<Cliente> clientes;

    public ClientEntity(){
        clientes = new ArrayList<>();
    }

    @Override
    public List<Cliente> buscarTodos() {
        return clientes;
    }

    @Override
    public void cadastrar(Cliente obj) {
        clientes.add(obj);
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
}
