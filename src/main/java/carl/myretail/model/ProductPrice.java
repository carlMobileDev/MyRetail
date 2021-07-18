package carl.myretail.model;

import java.io.Serializable;

import carl.myretail.repository.mongoDb.dto.Price;

public class ProductPrice implements Serializable{
    public double value;
    public String currencyCode;

    public ProductPrice(double value, String currencyCode){
        this.value = value;
        this.currencyCode = currencyCode;
    }

    public ProductPrice() {}

    public double getValue() {
        return this.value;
    }
    public void setValue(double value) {
        this.value = value;
    }

    public String currencyCode() {
        return this.currencyCode;
    }
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public ProductPrice(Price dto) {
        this.value = dto.getValue();
        this.currencyCode = dto.getCountryCode();
    }

    public Price toPrice(long id) {
        Price p = new Price();
        p.setProduct(id);
        p.setValue(this.value);
        p.setCountryCode(this.currencyCode);
        return p;
    }
}
