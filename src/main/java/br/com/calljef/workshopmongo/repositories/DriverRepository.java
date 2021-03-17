package br.com.calljef.workshopmongo.repositories;

import br.com.calljef.workshopmongo.domain.Driver;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends MongoRepository<Driver, String> {
}
