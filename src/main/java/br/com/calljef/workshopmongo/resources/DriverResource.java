package br.com.calljef.workshopmongo.resources;

import br.com.calljef.workshopmongo.domain.Driver;
import br.com.calljef.workshopmongo.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/drivers")
public class DriverResource {

    @Autowired
    private DriverService service;

    @GetMapping
    public ResponseEntity<List<Driver>> findAll() {
        List<Driver> l1 = service.findAll();
        return ResponseEntity.ok().body(l1);

    }
}
