package View ; 

import entity.Order;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hello
 */
public class main {
    public static void main (String args[]){
//        List<Order> orders= new ArrayList<Order>();
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/Order.odb");        
//        EntityManager em = emf.createEntityManager() ; 
//        Query query = em.createQuery("Select o " + "from Order o " + "where o.oId " + "Between 0 and 40000" );
//        orders =(ArrayList<Order>) query.getResultList() ;
//        
////        Order oo = em.find(Order.class, 1) ; 
////        System.out.println(oo.getoId());
//        System.out.println(orders.size());
//        for (int i=0;i<orders.size();i++){
//            System.out.println(orders.get(i).getoId());
////            System.out.println(orders.get(i).getItems().get(0).getProduct());
//        }
//        em.close();
//        emf.close();
        List<Order> orders= new ArrayList<Order>();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/Order.odb");        
        EntityManager em = emf.createEntityManager() ; 
        Query query = em.createQuery("Select o " + "from Order o");
        orders =(ArrayList<Order>) query.getResultList() ;
        
        Order oo = em.find(Order.class, 3) ; 
        System.out.println(oo.getoId());
        em.close();
        emf.close();
//        System.out.println(orders.size());
//        for (int i=0;i<orders.size();i++){
//            System.out.println(orders.get(i).getoId());
////            System.out.println(orders.get(i).getItems().get(0).getProduct());
//        }
       
    } 
}
