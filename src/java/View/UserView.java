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
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

@ManagedBean
@ApplicationScoped
public class UserView {

    private String firstname;

    private String lastname;
    private int userId=1;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    public static final String AUTH_KEY = "app.user.name";

    private static List users = new ArrayList<Users>();
    
    
    
    
    private String output;

   

   

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void save() {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Welcome " + firstname + " " + lastname));
    }

    public String onSubmit() {

        UsersIntialization user = new UsersIntialization(); //used for intializing database for the first use
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/Users.odb");
        EntityManager em = emf.createEntityManager();
         Query query = em.createQuery("Select o " + "from Users o");
        users = (ArrayList<Users>) query.getResultList();
        //Users h=em.find(Users.class, 1);
        em.close();
        emf.close();

//        FacesContext.getCurrentInstance().addMessage(null,
//                new FacesMessage(users.toString()));
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).toString().equals(firstname + "  " + lastname)) {
                
                return login();
            }
        }
        
        FacesContext.getCurrentInstance().addMessage(null,
               new FacesMessage("enter a valid \"username\" and \"password\""));
        return null;

    }
    public boolean isLoggedIn() {
    return FacesContext.getCurrentInstance().getExternalContext()
        .getSessionMap().get(AUTH_KEY) != null;
  }

  public String login() {
    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(
        AUTH_KEY, firstname);
        
    return "newOrder?faces-redirect=true";
  }

  public String logout() {
    FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
        .remove(AUTH_KEY);
        this.firstname="";
        this.lastname="";
    return "index?faces-redirect=true";
  }

}
