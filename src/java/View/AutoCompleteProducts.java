//package View;
//
// 
//import java.util.ArrayList;
//import java.util.List;
//import javax.annotation.PostConstruct;
//import javax.faces.bean.ApplicationScoped;
//import javax.faces.bean.ManagedBean;
// 
// 
//@ManagedBean(name="AllProducts", eager = true)
//@ApplicationScoped
//public class AllProducts {
//     
//    private List<String > products;
//    
//    public AllProducts(){
//          products = new ArrayList<String>();
//        products.add("product1");
//        products.add("product2");
//        products.add("product3");
//        products.add("product4");
//        products.add("product5");
//        products.add("product6");
//        products.add("product7");
//        products.add("product8");
//        products.add("product9");
//        products.add("product10");
//    }
//     
//    
//    
//     
//    public List<String> getProducts() {
//        return products;
//    } 
//     public List<String> completeTheme(String query) {
//        List<String> allThemes = products;
//        List<String> filteredThemes = new ArrayList<String>();
//         
//        for (int i = 0; i < allThemes.size(); i++) {
//            String skin = allThemes.get(i);
//            if(skin.toLowerCase().startsWith(query)) {
//                filteredThemes.add(skin);
//            }
//        }
//         
//        return filteredThemes;
//    }
//}



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
public class AutoCompleteProducts{
    

  
    private List<String> productsStr;

    public List<String> getProductsStr() {
        return productsStr;
    }

    public void setProductsStr(List<String> productsStr) {
        this.productsStr = productsStr;
    }
     

    
    
    
    
    
    
    public AutoCompleteProducts(){
        
        
        productsStr=new ArrayList<String>();
        inti();
       
        
    }
    
    public void inti(){
         productsStr.add("product1");
        productsStr.add("product2");
        productsStr.add("product3");
        productsStr.add("product4");
        productsStr.add("product5");
        productsStr.add("product6");
        productsStr.add("product7");
        productsStr.add("product8");
        productsStr.add("product9");
        productsStr.add("product10");
    }
    
     
    public List<String> completeTheme(String query) {
        List<String> allThemes = productsStr;
        List<String> filteredThemes = new ArrayList<String>();
         
        for (int i = 0; i < allThemes.size(); i++) {
            String skin = allThemes.get(i);
            if(skin.toLowerCase().startsWith(query)) {
                filteredThemes.add(skin);
            }
        }
         
        return filteredThemes;
    }
    
    
   
        
}
