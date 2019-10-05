/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Endereco;
import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.Pais;
import br.edu.ifsul.modelo.PessoaFisica;
import br.edu.ifsul.modelo.TipoEndereco;
import java.util.Calendar;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Diloan Silva
 * @email diloan.silva@gmail.com
 */
public class TestePersistirEndereco {

    EntityManager em;

    public TestePersistirEndereco() {
    }

    @Before
    public void setUp() {
        try {
            em = EntityManagerUtil.getEntityManager();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() {
        em.close();
    }

    @Test
    public void teste() {
        boolean exception = false;
        try {
            PessoaFisica pf = em.find(PessoaFisica.class, 3);
            Endereco e = new Endereco();
            e.setBairro("Barra da Tijuca");
            e.setCep("69810-320");
            e.setComplemento("Casa");
            e.setEndereco("Rosa das flores");
            e.setNickName("John");
            e.setNumero("345");
            e.setReferencia("Perto de alguma coisa"); 
            e.setTipoEndereco(em.find(TipoEndereco.class, 1));
            e.setCidade(em.find(Cidade.class, 2));
            pf.adicionarEndereco(e);
            em.getTransaction().begin();
            em.persist(pf);
            em.getTransaction().commit();

        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }

}
