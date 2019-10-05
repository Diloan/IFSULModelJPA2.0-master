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
public class TestePersistirCidade {

    EntityManager em;

    public TestePersistirCidade() {
    }

    @Before
    public void setUp() {

        em = EntityManagerUtil.getEntityManager();

    }

    @After
    public void tearDown() {
        em.close();
    }

    @Test
    public void teste() {
        boolean exception = false;
        try {
            Cidade c = new Cidade();
            c.setNome("Ananindeua");
            c.setEstado(em.find(Estado.class, 3));
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();

        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }

}
