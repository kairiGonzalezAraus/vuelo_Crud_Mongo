package cl.cocha.spring.vuelo.repository;

import cl.cocha.spring.vuelo.model.Vuelo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VueloRepository extends MongoRepository<Vuelo, String>{
	
}
