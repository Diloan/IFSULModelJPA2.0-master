
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Categoria;
import br.edu.ifsul.modelo.Foto;
import br.edu.ifsul.modelo.Marca;
import br.edu.ifsul.modelo.Produto;
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
 * @author ASUSX451
 */
public class TestePersistirFoto {
    
    EntityManager em;
    
    public TestePersistirFoto() {
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

            Produto p = em.find(Produto.class, 2);
            Foto f = new Foto();
            f.setNome("motoG.png");
            f.setDescricao("Foto do produto");
            Path path = Paths.get("C:\\Users\\ASUSX451\\Downloads\\Aulas\\Estudo estágio(NOVOS)\\Jorge Bavaresco\\JPA+Hibernate\\motoG.png");
            f.setArquivo(Files.readAllBytes(path));
            p.adicionarFoto(f);
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
