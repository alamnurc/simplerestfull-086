/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ws.b.project04;

/**
 *
 * @author alamnurcahaya
 */

//deklarasi kelas dan variabel
public class Product {
    private String id;
    private String name;
    private int price;
    private int quantity;
    private int total;
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getName() {
       return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public int getTotal() {
        return total;
    }

    public void setTotal() {
        this.total = price * quantity;
    }
    
}
