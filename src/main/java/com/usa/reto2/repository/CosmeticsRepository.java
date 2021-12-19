package com.usa.reto2.repository;

import com.usa.reto2.interfaces.CosmeticstInterface;
import com.usa.reto2.model.Cosmetics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CosmeticsRepository {
    @Autowired
    private CosmeticstInterface productMongoRepository;

    public List<Cosmetics> getAll(){
        return (List<Cosmetics>) productMongoRepository.findAll();
    }

    public Optional<Cosmetics> getProduct(String reference){
        return productMongoRepository.findById(reference);
    }

    public Cosmetics create(Cosmetics cosmetic){
        return productMongoRepository.save(cosmetic);
    }

    public void update(Cosmetics cosmetic){
        productMongoRepository.save(cosmetic);
    }

    public void delete(Cosmetics cosmetic){
        productMongoRepository.delete(cosmetic);
    }
}
