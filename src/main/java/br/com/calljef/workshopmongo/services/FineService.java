package br.com.calljef.workshopmongo.services;

import br.com.calljef.workshopmongo.domain.Driver;
import br.com.calljef.workshopmongo.domain.Fine;
import br.com.calljef.workshopmongo.dto.DriverDTO;
import br.com.calljef.workshopmongo.repositories.DriverRepository;
import br.com.calljef.workshopmongo.repositories.FineRepository;
import br.com.calljef.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FineService {

    @Autowired
    private FineRepository repo;

    public Fine findById(String id) {
        Optional<Fine> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public  List<Fine> findByText(String text) {
        return repo.searchByBody(text);
    }

}
