package com.api.crud.services;

import com.api.crud.models.entities.UserEntity;
import com.api.crud.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {

    @Autowired  //inyecto esta dependencia para usar los metodos de la interface
    IUserRepository userRepository;

    public ArrayList<UserEntity> getUsers() {
        return (ArrayList<UserEntity>) userRepository.findAll();
    }

    public UserEntity saveUser(UserEntity user) {
        return userRepository.save(user);
    }

    public Optional<UserEntity> getById(Long id) {   //Optional es como decir: opcionalmente traere algo de tipo UserModel xq puede ser que no encuentre nada y tenga que devolver null y si definimos que si o si sera de tipo UserModel y pasa eso se rompe
        return userRepository.findById(id); //si no uso optional debo poner un orElse(null)
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return userRepository.existsById(id);
    }

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

}
