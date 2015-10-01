/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author hello
 */
@Entity
@Table 
public class ItemEntity implements Serializable {
    
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long IId;
    private String product ; 
    private int quantity ;
    private String supplier ; 
    @JoinColumn(name="Order_ID") 
    private Order orderId; 

    public Order getOrderId() {
        return orderId;
    }

    public void setOrderId(Order orderId) {
        this.orderId = orderId;
    }
    

    public Long getIId() {
        return IId;
    }

    public void setIId(Long IId) {
        this.IId = IId;
    }

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

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (IId != null ? IId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemEntity)) {
            return false;
        }
        ItemEntity other = (ItemEntity) object;
        if ((this.IId == null && other.IId != null) || (this.IId != null && !this.IId.equals(other.IId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Item[ id=" + IId + " ]" + product ;
    }
    
}
