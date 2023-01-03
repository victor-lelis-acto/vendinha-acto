package br.com.acto.vendinha.entity;

import br.com.acto.vendinha.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClientEntity extends GenericEntity<Cliente>{
    public List<Cliente> Clientes;

    public ClientEntity(){
        Clientes = new ArrayList<>();
    }

    @Override
    public List<Cliente> buscarTodos() {
        return Clientes;
    }

    @Override
    public void cadastrar(Cliente obj) {
        Clientes.add(obj);
    }


}
