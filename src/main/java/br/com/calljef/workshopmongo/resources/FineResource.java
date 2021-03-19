package br.com.calljef.workshopmongo.resources;

import br.com.calljef.workshopmongo.domain.Fine;
import br.com.calljef.workshopmongo.resources.util.URL;
import br.com.calljef.workshopmongo.services.FineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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

    @GetMapping(value = "/fullsearch")
    public ResponseEntity<List<Fine>> fullsearch(
            @RequestParam(value = "text", defaultValue = "") String text,
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "minDate", defaultValue = "") String maxDate) {
        text = URL.decodeParam(text);
        Date min = URL.convertDate(minDate, new Date(0L));
        Date max = URL.convertDate(maxDate, new Date());
        List<Fine> list = service.fullSearch(text, min, max);
        return ResponseEntity.ok().body(list);
    }

}
