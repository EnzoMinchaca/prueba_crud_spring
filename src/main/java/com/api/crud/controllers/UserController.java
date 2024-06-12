package com.api.crud.controllers;

import com.api.crud.dto.UserDto;
import com.api.crud.models.UserModel;
import com.api.crud.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ArrayList<UserModel> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")    //tambien puede ser (path = "/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) { //aclaramos el tipo de dato que sera el campo por path, el nombre debe ser si o si igual
        if (!userService.existsById(id)) {   //tambien puede ser con un try catch
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        UserModel user = userService.getById(id).get();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> saveUser(@RequestBody UserDto userDto) {
        if(userDto.getFirstName() == null || userDto.getLastName() == null || userDto.getEmail() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        UserModel user = new UserModel(userDto.getFirstName(), userDto.getLastName(), userDto.getEmail());
        userService.saveUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUserById(@RequestBody UserDto userDto, @PathVariable Long id) {
        if (!userService.existsById(id)) {   //tambien puede ser con un try catch
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        UserModel user = userService.getById(id).get();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        userService.saveUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        if (!userService.existsById(id)) {   //tambien puede ser con un try catch
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
