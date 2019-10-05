/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.Pais;
import br.edu.ifsul.modelo.PessoaFisica;
import br.edu.ifsul.modelo.Produto;
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
public class TestePersistirDesejos {

    EntityManager em;

    public TestePersistirDesejos() {
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
            Produto p = em.find(Produto.class, 1);
            pf.getDesejos().add(p);
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();

        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
            e.getMessage();
        }
        Assert.assertEquals(false, exception);
    }

}
