package br.com.calljef.workshopmongo.services;

import br.com.calljef.workshopmongo.domain.Driver;
import br.com.calljef.workshopmongo.dto.DriverDTO;
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

    public Driver insert(Driver obj) {
        return repo.insert(obj);
    }

    public void deleteById(String id) {
        findById(id);
        repo.deleteById(id);
    }

    public Driver update(Driver obj) {
        Driver newObj = repo.findById(obj.getId()).orElseThrow(() -> new ObjectNotFoundException("Object not found"));
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    public void updateData(Driver newObj, Driver obj) {
        newObj.setName(obj.getName());
        newObj.setCnh(obj.getCnh());
    }

    public Driver fromDTO(DriverDTO objDTO) {
        return new Driver(objDTO.getId(), objDTO.getName(), objDTO.getCnh());
    }
}
