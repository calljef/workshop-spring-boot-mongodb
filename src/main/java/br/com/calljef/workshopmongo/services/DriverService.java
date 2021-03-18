package br.com.calljef.workshopmongo.services;

import br.com.calljef.workshopmongo.domain.Driver;
import br.com.calljef.workshopmongo.repositories.DriverRepository;
import br.com.calljef.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverService {

    @Autowired
    private DriverRepository repo;

    public List<Driver> findAll() {
        return repo.findAll();

    }

    public Driver findById(String id) {
        Optional<Driver> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }
}
