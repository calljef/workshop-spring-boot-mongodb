package br.com.calljef.workshopmongo.resources;

import br.com.calljef.workshopmongo.domain.Driver;
import br.com.calljef.workshopmongo.dto.DriverDTO;
import br.com.calljef.workshopmongo.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/drivers")
public class DriverResource {

    @Autowired
    private DriverService service;

    @GetMapping
    public ResponseEntity<List<DriverDTO>> findAll() {
        List<Driver> l1 = service.findAll();
        List<DriverDTO> l1DTO = l1.stream().map(x -> new DriverDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(l1DTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DriverDTO> findById(@PathVariable String id) {
        Driver d1 = service.findById(id);
        return ResponseEntity.ok().body(new DriverDTO(d1));
    }

    @PutMapping()
    public ResponseEntity<Void> insert(@RequestBody DriverDTO objDTO) {
        Driver d1 = service.fromDTO(objDTO);
        d1 = service.insert(d1);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(d1.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
