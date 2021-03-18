package br.com.calljef.workshopmongo.resources;

import br.com.calljef.workshopmongo.domain.Fine;
import br.com.calljef.workshopmongo.services.FineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/fines")
public class FineResource {

    @Autowired
    private FineService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Fine> findById(@PathVariable String id) {
        Fine d1 = service.findById(id);
        return ResponseEntity.ok().body(d1);
    }

}
