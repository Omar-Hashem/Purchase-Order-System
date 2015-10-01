/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author hello
 */
@ManagedBean
@ApplicationScoped
public class DeleteDB {
    public static void main(String args[]){
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/Order.odb;drop");
        EntityManager em = emf.createEntityManager();
    }
}
