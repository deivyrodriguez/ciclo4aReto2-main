package com.usa.reto2.repository;

import com.usa.reto2.interfaces.UserInterface;
import com.usa.reto2.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    @Autowired
    private UserInterface userMongoRepository;

    public List<User> getAll(){
        return (List<User>) userMongoRepository.findAll();
    }

    public Optional<User> getUser(int id){
        return userMongoRepository.findById(id);
    }

    public User create(User user){
        return userMongoRepository.save(user);
    }

    public void update(User user){
        userMongoRepository.save(user);
    }

    public void delete(User user){
        userMongoRepository.delete(user);
    }

    public boolean emailexist(String email){
        Optional<User> usuario = userMongoRepository.findByEmail(email);
        return !usuario.isEmpty();
    }

    public Optional<User> authenticateUser(String email, String password){
        return userMongoRepository.findByEmailAndPassword(email, password);
    }

    public Optional<User> getUserByNameOrEmail(String name, String email){
        return userMongoRepository.findByNameOrEmail(name, email);
    }
}
