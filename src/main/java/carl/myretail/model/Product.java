
package carl.myretail.model;

import java.io.Serializable;


public class Product implements Serializable{
    public long id;
    public String name;
    public ProductPrice currentPrice;

    public Product() {
        this.name = "hello";
    }

    public Product(long id, String name, ProductPrice currentPrice) {
        this.id = id;
        this.name = name;
        this.currentPrice = currentPrice;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public ProductPrice getCurrentPrice() {
        return this.currentPrice;
    }
    public void setCurrentPrice(ProductPrice price) {
        this.currentPrice = price;
    }
    
}