/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Arquivo;
import br.edu.ifsul.modelo.Foto;
import java.io.File;
import java.io.FileOutputStream;
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
public class TesteLerArquivo {
    
    EntityManager em;
    
    public TesteLerArquivo() {
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

           Arquivo a = em.find(Arquivo.class, 1);
           File file = new File("Passar path de um arquivo com extensão");
           FileOutputStream out = new FileOutputStream(file);
           out.write(a.getArquivo());
           out.close();
           
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
    
}
