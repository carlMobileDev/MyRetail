package carl.myretail.repository.mongoDb.dto;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Price {
    @Id
    ObjectId id;
    long product;
    double value;
    String countryCode;

    public Price(ObjectId id, long product, double value, String countryCode) {
        this.id = id;
        this.product = product;
        this.value = value;
        this.countryCode = countryCode;
    }
    public Price(){}


    public ObjectId getId() {
        return this.id;
    }
    public void setId(ObjectId id) {
        this.id = id;
    }

    public long getProduct(){
         return this.product;
     }
     public void setProduct(long product) {
         this.product = product;
     }
     public double getValue(){
         return this.value;
     }
     public void setValue(double value) {
        this.value = value;
     }
     public String getCountryCode() {
         return this.countryCode;
     }
     public void setCountryCode(String code) {
         this.countryCode = code;
     }
}
