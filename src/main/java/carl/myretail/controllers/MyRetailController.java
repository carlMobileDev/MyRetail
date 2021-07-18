package carl.myretail.controllers;


import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

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
        
        Optional<Price>  priceDto = priceRepository.findByProduct(id);
        
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
        
        Optional<Price>  optionalPrice = priceRepository.findByProduct(id);
        
        Price inputPrice = product.currentPrice.toPrice(id);
        Price priceDto = new Price();
        if (optionalPrice.isPresent()) {
            priceDto = optionalPrice.get();
            priceDto.setCountryCode(inputPrice.getCountryCode());
            priceDto.setValue(inputPrice.getValue());
            priceRepository.save(priceDto);
        } else {
            priceRepository.save(inputPrice);
        }

        return new Product(id, productName, new ProductPrice(inputPrice));
    }

}
