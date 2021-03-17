package br.com.calljef.workshopmongo.resources;

import br.com.calljef.workshopmongo.domain.Driver;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/drivers")
public class DriverResource {

    @GetMapping
    public ResponseEntity<List<Driver>> findAll() {
        Driver d1 = new Driver("1", "jefeson", "09223456787");
        Driver d2 = new Driver("2", "Ferreira", "1234567896");
        List<Driver> l1 = new ArrayList<>();
        l1.addAll(Arrays.asList(d1,d2));
        return ResponseEntity.ok().body(l1);

    }
}
