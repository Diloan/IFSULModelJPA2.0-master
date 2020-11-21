/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Categoria;
import br.edu.ifsul.modelo.Marca;
import br.edu.ifsul.modelo.Produto;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Diloan Silva
 * @email diloan.silva@gmail.com
 */
public class TestePersistirProduto {
    
    EntityManager em;
    
    public TestePersistirProduto() {
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
    public void Teste(){
        boolean exception = false;
        try {
//           
            Produto p = new Produto();
            p.setNome("Moto Z4");
            p.setCategoria(em.find(Categoria.class, 2));
            p.setMarca(em.find(Marca.class, 3));
            p.setDescricao("Aparelho intermediário/top de linha");
            p.setPreco(1600.00);
            p.setQuantidadeEstoque(2.00);
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
    
}
