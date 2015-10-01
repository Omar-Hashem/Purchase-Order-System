package View;

 
import java.io.Serializable;
 
public class Item implements Serializable {
     
    private String product ;
    private int quantity ; 
    private String supplier  ;

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
    
 
    
 
    public boolean equals(Object obj) {
        if(!(obj instanceof Item))
            return false ;
         
        Item item = (Item) obj;
        return ((item.getProduct() != null && item.getProduct().equals(product)) && (item.getQuantity()==quantity) && (item.getSupplier() != null && item.getSupplier().equals(supplier)));

    }
 
    public int hashCode() {
        int hash = 1;
        if(product  != null)
            hash = hash * 31 + product.hashCode();
        return hash;
    }
}