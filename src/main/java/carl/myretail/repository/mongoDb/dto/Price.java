package carl.myretail.repository.mongoDb.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Price {
    @Id
    long _id;
    double value;
    String countryCode;

    public Price(long id, double value, String countryCode) {
        this._id = id;
        this.value = value;
        this.countryCode = countryCode;
    }
    public Price(){}


    public long get_Id(){
         return this._id;
     }
     public void set_Id(long id) {
         this._id = id;
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
