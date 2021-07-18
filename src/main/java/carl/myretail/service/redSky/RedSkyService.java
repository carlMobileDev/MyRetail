package carl.myretail.service.redSky;


import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.cache.annotation.Cacheable;
import org.json.JSONObject; 

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class RedSkyService {
    
    @Bulkhead(name= "redSkyService")
    @CircuitBreaker(name="redSkyService")
    @Cacheable("products")
    public String getNameForProductId(long id) {

        String url = "https://redsky.target.com/v3/pdp/tcin/{id}?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics&key=candidate";
        RestTemplate template = new RestTemplateBuilder().build();

        String response = template.getForObject(url, String.class, id);
        
        return extractTitleFromResponse(response);
    }

    public String extractTitleFromResponse(String response) {
        JSONObject object = new JSONObject(response);
        String title = object.getJSONObject("product")
        .getJSONObject("item")
        .getJSONObject("product_description")
        .get("title").toString();

        return title;

    }
}

