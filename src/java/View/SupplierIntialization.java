/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import entity.Supplier;
import entity.Users;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author hello
 */
public class SupplierIntialization {

     public SupplierIntialization() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/Supplier.odb");
        EntityManager em = emf.createEntityManager();
        Supplier sup = new Supplier();
        sup.setSupName("ahmed");
        
        em.getTransaction().begin();
        em.persist(sup);
        em.getTransaction().commit();
        em.clear();
        
        Supplier sup2 = new Supplier();
        sup2.setSupName("yasser");
        em.getTransaction().begin();
        em.persist(sup2);
        em.getTransaction().commit();
        em.clear();
         
        
        Supplier sup3 = new Supplier();
        sup3.setSupName("hamdy");
        em.getTransaction().begin();
        em.persist(sup3);
        em.getTransaction().commit();
        em.clear();
        
        Supplier sup4 = new Supplier();
        sup4.setSupName("3essa");
        em.getTransaction().begin();
        em.persist(sup4);
        em.getTransaction().commit();
        em.clear();
        
                
                
        em.close();
        emf.close();
    }
    
       
    
}