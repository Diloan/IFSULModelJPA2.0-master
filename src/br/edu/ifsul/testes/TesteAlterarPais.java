/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Pais;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ASUSX451
 */
public class TesteAlterarPais {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("IFSULModelPU");
        EntityManager em = EntityManagerUtil.getEntityManager();
        Pais p = em.find(Pais.class, 12);
        p.setNome("Coréia do Sul");
        p.setIso("CDS");
        em.getTransaction().begin();
        em.merge(p);
        em.getTransaction().commit();
        em.close();
//        emf.close();
        
    }
    
}
