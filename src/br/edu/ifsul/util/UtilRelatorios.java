/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.util;

import br.edu.ifsul.modelo.Categoria;
import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Endereco;
import br.edu.ifsul.modelo.Marca;
import br.edu.ifsul.modelo.PessoaFisica;
import br.edu.ifsul.modelo.Produto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diloan Silva <diloan.silva@gmail.com>
 */
public class UtilRelatorios {

    public static List<Produto> listaProdutos() {
        List<Produto> lista = new ArrayList<>();
        Categoria c = new Categoria();
        c.setNome("Eletrônicos");
        Marca samsung = new Marca();
        samsung.setNome("Samsung");
        Marca dell = new Marca();
        dell.setNome("Dell");
        Produto p1 = new Produto();
        p1.setNome("Mouse Laser");
        p1.setDescricao("Mouse com alta precisão");
        p1.setPreco(140.0);
        p1.setQuantidadeEstoque(40.0);
        p1.setCategoria(c);
        p1.setMarca(dell);
        Produto p2 = new Produto();
        p2.setNome("Impressora Deskjet");
        p2.setDescricao("Impressora jato de tinta");
        p2.setPreco(180.0);
        p2.setQuantidadeEstoque(3.0);
        p2.setCategoria(c);
        p2.setMarca(samsung);
        Produto p3 = new Produto();
        p3.setNome("HD USB 1TB");
        p3.setDescricao("HD Externo USB 1TB");
        p3.setPreco(450.0);
        p3.setQuantidadeEstoque(30.0);
        p3.setCategoria(c);
        p3.setMarca(samsung);

        lista.add(p1);
        lista.add(p2);
        lista.add(p3);

        return lista;
    }
    
    public static List<PessoaFisica> listaPessoas(){
        List<PessoaFisica> lista = new ArrayList<>();
        PessoaFisica pf = new PessoaFisica();
        pf.setNome("Diloan Silva");
        pf.setEmail("diloan.silva@gmail.com");
        pf.setTelefone("(91)99989-4668");
        pf.setRg("8966644889");
        pf.setCpf("789.098.077-99");
        Endereco e = new Endereco();
        e.setEndereco("Rua Sao Paulo");
        e.setNumero("889");
        e.setComplemento("Prox. ao Anestor");
        e.setBairro("Nova Brasília");
        e.setCep("68721-000");
        Cidade c = new Cidade();
        c.setNome("Salinópolis");
        e.setCidade(c);
        pf.adicionarEndereco(e);
        Produto p1 = new Produto();
        p1.setNome("Mouse sem fio");
        Produto p2 = new Produto();
        p2.setNome("Teclado sem fio");
        pf.getDesejos().add(p1);
        pf.getDesejos().add(p2);
        lista.add(pf);
        return lista;
    }
}
