package br.com.calljef.workshopmongo.services;

import br.com.calljef.workshopmongo.domain.Driver;
import br.com.calljef.workshopmongo.repositories.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {

    @Autowired
    private DriverRepository repo;

    public List<Driver> findAll() {
        return repo.findAll();

    }
}
