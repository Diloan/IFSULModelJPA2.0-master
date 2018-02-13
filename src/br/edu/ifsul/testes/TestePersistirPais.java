/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Pais;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

/**
 *
 * @author ASUSX451
 */
public class TestePersistirPais {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Criado o objeto do EntityManagerFactory
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("IFSULModelPU");
        EntityManager em = EntityManagerUtil.getEntityManager();
        Pais p = new Pais();

        p.setNome("Coréia do Sul");
        p.setIso("COS");
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
//        emf.close();
    }
    
}
