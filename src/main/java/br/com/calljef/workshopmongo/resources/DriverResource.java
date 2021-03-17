package br.com.calljef.workshopmongo.resources;

import br.com.calljef.workshopmongo.domain.Driver;
import br.com.calljef.workshopmongo.dto.DriverDTO;
import br.com.calljef.workshopmongo.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
