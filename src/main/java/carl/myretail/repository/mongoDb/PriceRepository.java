package carl.myretail.repository.mongoDb;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import carl.myretail.repository.mongoDb.dto.Price;

@Service
public interface PriceRepository extends MongoRepository<Price, String>{
    
   // public List<PriceDTO> findAll();
   public Optional<Price> findByProduct(long product);

}
