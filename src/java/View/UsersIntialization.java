package View;


import entity.Users;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hello
 */
public class UsersIntialization {

    public UsersIntialization() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/Users.odb");
        EntityManager em = emf.createEntityManager();
        Users user = new Users();
        user.setName("ahmed shawky");
        user.setEmail("ahmed@gmail.com");
        user.setPassword("pass");
        user.setOrders(null);
        
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.clear();
        
         
        em.getTransaction().begin();
        Users user2 = new Users();
        user2.setName("omar shawky");
        user2.setEmail("omar@gmail.com");
        user2.setPassword("pass");
        user2.setOrders(null);
         
        
        em.persist(user2);
       em.getTransaction().commit();
       em.clear();
         
        em.getTransaction().begin();
        Users user3 = new Users();
        user3.setName("omar hashim");
        user3.setEmail("omar@gmail.com");
        user3.setPassword("pass");
        user3.setOrders(null);
        
        
        em.persist(user3);
        
        em.getTransaction().commit();
        
         em.close();
        emf.close();
    }
    
       
    
}
