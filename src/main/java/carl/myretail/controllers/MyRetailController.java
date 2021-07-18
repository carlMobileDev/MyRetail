package carl.myretail.controllers;



import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import carl.myretail.model.ProductPrice;
import carl.myretail.model.Product;
import carl.myretail.repository.mongoDb.PriceRepository;
import carl.myretail.repository.mongoDb.dto.Price;
import carl.myretail.service.redSky.RedSkyService;

@Controller
@RequestMapping(value = "/products/")
public class MyRetailController {

    @Autowired
    RedSkyService redSkyService;

    @Autowired
    PriceRepository priceRepository;

    @GetMapping(
        value = "{id}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public @ResponseBody Product getProductDataForId(@PathVariable Long id) {
        
        String productName = redSkyService.getNameForProductId(id);
        
        Optional<Price>  priceDto = priceRepository.findById(id);
        
        if (!priceDto.isPresent()){
            return new Product(id, productName, null);
        }

        return new Product(id, productName, new ProductPrice(priceDto.get()));
    }


    @PutMapping(
        value = "{id}",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes= MediaType.APPLICATION_JSON_VALUE
    )
    public @ResponseBody Product getProductDataForId(@PathVariable Long id, @RequestBody Product product) {
        
        String productName = redSkyService.getNameForProductId(id);
        
        priceRepository.save(product.currentPrice.toPrice(id));

        return new Product(id, productName, new ProductPrice(product.currentPrice.toPrice(id)));
    }

}
