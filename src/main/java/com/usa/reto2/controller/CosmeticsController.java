package com.usa.reto2.controller;

import com.usa.reto2.model.Cosmetics;
import com.usa.reto2.service.CosmeticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/cosmetics")
@CrossOrigin("*")
public class CosmeticsController {
    @Autowired
    private CosmeticsService cosmeticsService;

    @GetMapping("/all")
    public List<Cosmetics> getAll(){
        return cosmeticsService.getAll();
    }

    @GetMapping("/{reference}")
    public Optional<Cosmetics> getProduct(@PathVariable("reference") String reference){
        return cosmeticsService.getProduct(reference);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Cosmetics create(@RequestBody Cosmetics gadget){
        return cosmeticsService.create(gadget);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cosmetics update(@RequestBody Cosmetics gadget){
        return cosmeticsService.update(gadget);
    }
    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference){
        return cosmeticsService.delete(reference);
    }
}
