package com.usa.reto2.interfaces;

import com.usa.reto2.model.Cosmetics;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CosmeticstInterface extends MongoRepository<Cosmetics, String> {

}
