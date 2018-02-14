/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
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
 * @author ASUSX451
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
            System.out.println("Nulo");
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
            PessoaFisica pf = em.find(PessoaFisica.class, 1);
            Endereco e = new Endereco();
            e.setBairro("Guanabara");
            e.setCep("67010-320");
            e.setComplemento("Altos e baixos");
            e.setEndereco("Rosa vermelha");
            e.setNickName("Dilo");
            e.setNumero("487");
            e.setReferencia("Perto do Edson"); 
            e.setTipoEndereco(em.find(TipoEndereco.class, 1));
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
