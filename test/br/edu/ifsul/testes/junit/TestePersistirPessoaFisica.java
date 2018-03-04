/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.Pais;
import br.edu.ifsul.modelo.PessoaFisica;
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
public class TestePersistirPessoaFisica {

    EntityManager em;

    public TestePersistirPessoaFisica() {
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
            PessoaFisica pf = new PessoaFisica();
            pf.setCpf("031.450.022-79");
            pf.setEmail("julianamends.lima@gmail.com");
            pf.setNascimento(Calendar.getInstance());
            pf.setNome("Juliana Mendes");
            pf.setNomeUsuario("julianamendes");
            
//            pf.setNascimento(nascimento);
            pf.setRg("000000");
            pf.setSenha("julia");
            pf.setTelefone("(91)92222-2222");
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
