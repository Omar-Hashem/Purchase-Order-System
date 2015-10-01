/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import entity.Supplier;
import entity.Users;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author hello

*/
@ManagedBean
@ApplicationScoped
public class AutoComplete {
    

    private List<Supplier> suppliers;
    private List<String> suppliersStr;
    private String currentSupplier;
     

    public String getCurrentSupplier() {
        return currentSupplier;
    }

    public void setCurrentSupplier(String currentSupplier) {
        this.currentSupplier = currentSupplier;
    }
   
    public List<String> getSuppliersStr() {
        return suppliersStr;
    }

    public void setSuppliersStr(List<String> suppliersStr) {
        this.suppliersStr = suppliersStr;
    }
    
    
    
    
    public AutoComplete(){
        
        
        suppliersStr=new ArrayList<String>();
         SupplierIntialization supplier=new SupplierIntialization();
        inti();
       
        
    }
    
    public void inti(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/Supplier.odb");
        EntityManager em = emf.createEntityManager();
         Query query = em.createQuery("Select o " + "from Supplier o");
        suppliers = (ArrayList<Supplier>) query.getResultList();
        //Users h=em.find(Users.class, 1);
        em.close();
        emf.close();
         for(int i=0;i<suppliers.size();i++){
           suppliersStr.add(suppliers.get(i).toString());
       }
//        suppliersStr.add("ahmed");
//        suppliersStr.add("omar");
//        suppliersStr.add("mohamed");
      
    }
    
     
    public List<String> completeTheme(String query) {
        List<String> allThemes = suppliersStr;
        List<String> filteredThemes = new ArrayList<String>();
         
        for (int i = 0; i < allThemes.size(); i++) {
            String skin = allThemes.get(i);
            if(skin.toLowerCase().startsWith(query)) {
                filteredThemes.add(skin);
            }
        }
         
        return filteredThemes;
    }
    
    
    public List<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<Supplier> suppliers) {
        this.suppliers = suppliers;
    }   
        
        
}
