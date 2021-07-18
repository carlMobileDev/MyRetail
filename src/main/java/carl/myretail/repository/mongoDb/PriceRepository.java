package carl.myretail.repository.mongoDb;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import carl.myretail.repository.mongoDb.dto.Price;

@Service
public interface PriceRepository extends MongoRepository<Price, Long>{
    
   public Optional<Price> findBy_Id(long _id);

}
