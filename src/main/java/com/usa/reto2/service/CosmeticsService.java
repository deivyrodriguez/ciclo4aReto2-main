package com.usa.reto2.service;

import com.usa.reto2.model.Cosmetics;
import com.usa.reto2.repository.CosmeticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CosmeticsService {
    @Autowired
    private CosmeticsRepository cosmeticsRepository;

    public List<Cosmetics> getAll(){
        return cosmeticsRepository.getAll();
    }

    public Optional<Cosmetics> getProduct(String reference){
        return cosmeticsRepository.getProduct(reference);
    }

    public Cosmetics create(Cosmetics cosmetic){
        if (cosmetic.getReference() == null){
            return cosmetic;
        }else {
            return cosmeticsRepository.create(cosmetic);
        }
    }

    public Cosmetics update(Cosmetics cosmetic){
        if (cosmetic.getReference() != null){
            Optional<Cosmetics> cosmeticDb = cosmeticsRepository.getProduct(cosmetic.getReference());
            if (!cosmeticDb.isEmpty()){

                if (cosmetic.getBrand() != null){
                    cosmeticDb.get().setBrand(cosmetic.getBrand());
                }
                if (cosmetic.getCategory() != null){
                    cosmeticDb.get().setCategory(cosmetic.getCategory());
                }
                if (cosmetic.getDescription() != null){
                    cosmeticDb.get().setDescription(cosmetic.getDescription());
                }
                if (cosmetic.getPrice() != 0.0){
                    cosmeticDb.get().setPrice(cosmetic.getPrice());
                }
                if (cosmetic.getQuantity() != 0.0){
                    cosmeticDb.get().setQuantity(cosmetic.getQuantity());
                }
                if (cosmetic.getPhotography() != null){
                    cosmeticDb.get().setPhotography(cosmetic.getPhotography());
                }
                cosmeticDb.get().setAvailability(cosmetic.isAvailability());
                cosmeticsRepository.update(cosmeticDb.get());
                return cosmeticDb.get();
            }else {
                return cosmetic;
            }
        }else{
            return cosmetic;
        }
    }

    public boolean delete(String reference){
        Boolean aBoolean = getProduct(reference).map(product ->{
            cosmeticsRepository.delete(product);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
