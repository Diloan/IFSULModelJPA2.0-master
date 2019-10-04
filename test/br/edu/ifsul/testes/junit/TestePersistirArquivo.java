
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Arquivo;
import br.edu.ifsul.modelo.Produto;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author ASUSX451
 */
public class TestePersistirArquivo {
    
    EntityManager em;
    
    public TestePersistirArquivo() {
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
            Arquivo a = new Arquivo();
            a.setNome("Roupas.png");
            a.setDescricao("Arquivo do produto");
            Path path = Paths.get("C:\\Users\\ASUSX451\\Downloads\\Aulas\\Estudo estágio(NOVOS)\\Jorge Bavaresco\\JPA+Hibernate\\Teste_Arquivo.pdf");
            a.setArquivo(Files.readAllBytes(path));
            p.adicionarArquivo(a);
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
