package View;

 
import View.Item;
import entity.ItemEntity;
import entity.Order;
import entity.Supplier;
import entity.Users;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
 
@ManagedBean
@ApplicationScoped
public class CollectorView implements Serializable {
     
    private Item item;
    private List<Item> items;
    
    
    int cnt = 0 ; 

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }
     
    @PostConstruct
    public void init() {
        item = new Item();
        items = new ArrayList<Item>();
       
         
    }
     
    public void submitAction () throws ParseException{
        FacesContext fc = FacesContext.getCurrentInstance() ; 
        Map<String,String> params = fc.getExternalContext().getRequestParameterMap() ; 
        int userID = Integer.parseInt(params.get("submitBtn"));
        
        java.util.Calendar cal = java.util.Calendar.getInstance();
        String dateInString = new java.text.SimpleDateFormat("EEEE, dd/MM/yyyy/hh:mm:ss").format(cal.getTime());
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE, dd/MM/yyyy/hh:mm:ss");
        Date date = formatter.parse(dateInString);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/Order.odb");        
        EntityManager em = emf.createEntityManager() ; 
        Users user = em.find(Users.class, userID) ;
        em.getTransaction().begin();
        Order order = new Order (); 
        order.setDate(date);
        order.setUserId(user);
        em.persist(order);
        em.getTransaction().commit();
        for(int i=0;i<items.size();i++){
            ItemEntity itemEntity = new ItemEntity(); 
            itemEntity.setProduct(item.getProduct());
            itemEntity.setQuantity(item.getQuantity());
            itemEntity.setSupplier(item.getSupplier());
            itemEntity.setOrderId(order);
            em.getTransaction().begin() ;
            em.persist(itemEntity) ; 
            em.getTransaction().commit(); 
        }
       

        em.close();
        emf.close();
        
        
        
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/Order.odb");        
//        EntityManager em = emf.createEntityManager() ; 
//        em.getTransaction().begin();
//        List<ItemEntity> itemsEntities = new ArrayList<ItemEntity>(); 
//        for(int i=0;i<items.size();i++){
//            ItemEntity itemEntity = new ItemEntity(); 
//            itemEntity.setProduct(item.getProduct());
//            itemEntity.setQuantity(item.getQuantity());
//            itemEntity.setSupplier(item.getSupplier());
//            em.persist(itemEntity) ; 
//            itemsEntities.add(itemEntity) ;
//        }
//       Order order = new Order();
//       order.setDate(date) ; 
//       order.setItems(itemsEntities);
//       em.persist(order); 
//       em.getTransaction().commit();
//
//        em.close();
//        emf.close();
//        
        items.clear();
        
        
    }
    
    
//    public static void main (String args[] ){
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/Order.odb");        
//        EntityManager em = emf.createEntityManager() ; 
//        em.getTransaction().begin();
//        Query q = em.createQuery("Select o " + "from Order o" ); 
//        ArrayList<Order> ors  = new ArrayList<Order> () ; 
//        ors = (ArrayList<Order>) q.getResultList() ; 
//        for (int i=0;i<ors.size();i++ ){
//            System.out.println(ors.get(i).getItems().t);
//        }
//        em.getTransaction().commit();
//    }
    
    
    
    public void createNew() { 
        items.add(item);
        item = new Item();
    }
     
    public String reinit() {
        item = new Item();
         
        return null;
    }
 
    public Item getItem() {
        return item;
    }
 
    public List<Item> getItems() {
        return items;
    }
}