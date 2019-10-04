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
import java.util.List;
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
public class TesteListarCidade {

    EntityManager em;

    public TesteListarCidade() {
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
            //Usando JPA Query Language
            String jpql = "from Cidade order by nome";
            List<Cidade> listaCid = em.createQuery(jpql).getResultList();
            for(Cidade c : listaCid){
                System.out.println("ID: " + c.getId() + " Nome: " + c.getNome() + " Estado: " + c.getEstado().getNome());
            }

        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }

}
