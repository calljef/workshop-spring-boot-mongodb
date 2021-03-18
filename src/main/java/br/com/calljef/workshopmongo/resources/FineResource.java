package br.com.calljef.workshopmongo.resources;

import br.com.calljef.workshopmongo.domain.Fine;
import br.com.calljef.workshopmongo.resources.util.URL;
import br.com.calljef.workshopmongo.services.FineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.util.List;

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

    @GetMapping(value = "/textsearch")
    public ResponseEntity<List<Fine>> findByText(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List<Fine> list = service.findByText(text);
        return ResponseEntity.ok().body(list);
    }

}
