package br.com.calljef.workshopmongo.repositories;

import br.com.calljef.workshopmongo.domain.Fine;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FineRepository extends MongoRepository<Fine, String> {
    List<Fine> findByBodyContainingIgnoreCase(String text);
}
