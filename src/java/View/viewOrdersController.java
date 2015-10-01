package View;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entity.Order;
import entity.Users;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author hello
 */
@ManagedBean
@RequestScoped
public class viewOrdersController {

    List<Order> orders ; 
    
    private int userID;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
    
   
    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
    public viewOrdersController() {
       
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/Order.odb");        
        EntityManager em = emf.createEntityManager() ;
        orders= new ArrayList<Order>();
        Query query = em.createQuery("Select o " + "from Order o" );
        orders =(ArrayList<Order>) query.getResultList() ;
       
       
    }
    public String viewOrdersLink (){
//        FacesContext fc = FacesContext.getCurrentInstance() ; 
//        Map<String,String> params = fc.getExternalContext().getRequestParameterMap() ; 
//        userID = Integer.parseInt(params.get("userID")); 
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/Users.odb");        
//        EntityManager em = emf.createEntityManager() ; 
//        Users user = em.find(Users.class, userID) ; 
//        orders = user.getOrders() ;
//        em.close();
//        emf.close();
        return "viewOrders?faces-redirect=true" ; 
    }
    
    
    
}
