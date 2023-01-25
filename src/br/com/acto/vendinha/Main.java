package br.com.acto.vendinha;

import br.com.acto.vendinha.entity.ClienteEntity;
import br.com.acto.vendinha.entity.PessoaFisicaEntity;
import br.com.acto.vendinha.entity.PessoaJuridicaEntity;
import br.com.acto.vendinha.entity.ProdutoEntity;
import br.com.acto.vendinha.model.Cliente;
import br.com.acto.vendinha.model.PessoaFisica;
import br.com.acto.vendinha.model.PessoaJuridica;
import br.com.acto.vendinha.model.Produto;
import br.com.acto.vendinha.util.SqlUtil;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class Main {

    public static void main(String[] args) throws SQLException, ParseException {
        criarTabelas();

        ClienteEntity clienteEntity = new ClienteEntity();
        clienteEntity.inserirCliente("Agatha", "agatha@gmail.com"
        ,221235, "67 9999-9666");
        clienteEntity.inserirCliente(new Cliente("jao da silva", "jaojao^2@gmail.com", 3214567, "67 4002-8922"));
        System.out.println("Buscando clientes cadastrados");
        List<Cliente> clientes = clienteEntity.buscarTodos();
        System.out.println(clientes);

        PessoaFisicaEntity pessoaFisicaEntity = new PessoaFisicaEntity();
        pessoaFisicaEntity.inserirPessoaFisica("cubonito", 69, "Rua das graças", "67 1111-1111", "12345778", "000000000", "masculino");
        pessoaFisicaEntity.inserirPessoaFisica(new PessoaFisica("francisco", 14,"67 1111-1111","Rua Calógeras" ,"00000023", "646383636", "11111111"));
        System.out.println("Buscando Pessoas Fisicas Cadastradas");
        List <PessoaFisica> pessoasFisicas = pessoaFisicaEntity.buscarTodos();
        System.out.println(pessoasFisicas);

        PessoaJuridicaEntity pessoaJuridicaEntity = new PessoaJuridicaEntity();
        pessoaJuridicaEntity.inserirPessoaJuridica("ACTO BR", "RUA RIO DOCE 220", "67 1212-2121", "009787744", "ACTO BR SOLUÇÕES");
        List<PessoaJuridica> pessoasJuridicas = pessoaJuridicaEntity.buscarTodos();
        System.out.println(pessoasJuridicas);

        ProdutoEntity produtoEntity = new ProdutoEntity();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date data = formato.parse("23/11/2015");
        produtoEntity.inserirProduto("Cerveja Glacial", 0.00, "Glacial", "Dor de Barriga", new java.sql.Date(data.getTime()));
        List<Produto> produtos = produtoEntity.buscarTodos();
        System.out.println(produtos);

    }

    private static void criarTabelas() {
        try {
            SqlUtil.criarTabelaCliente();
            SqlUtil.criarTabelaPessoaFisica();
            SqlUtil.criarTabelaPessoaJuridica();
            SqlUtil.criarTabelaProduto();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}