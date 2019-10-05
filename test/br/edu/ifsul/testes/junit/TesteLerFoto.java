/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Categoria;
import br.edu.ifsul.modelo.Foto;
import br.edu.ifsul.modelo.Marca;
import br.edu.ifsul.modelo.Produto;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
public class TesteLerFoto {
    
    EntityManager em;
    
    public TesteLerFoto() {
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

           Foto f = em.find(Foto.class, 1);
           File file = new File("Passar path de um arquivo com extensao");
           FileOutputStream out = new FileOutputStream(file);
           out.write(f.getArquivo());
           out.close();
           
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
    
}
