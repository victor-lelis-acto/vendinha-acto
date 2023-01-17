package br.com.acto.vendinha.entity;

import br.com.acto.vendinha.model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ClientEntity extends br.com.acto.vendinha.entity.GenericEntity<Cliente> {
    public List<Cliente> clientes;

    public ClientEntity(){
        clientes = new ArrayList<Cliente>();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClientEntity that)) return false;
        return Objects.equals(getClientes(), that.getClientes());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClientes());
    }
}
