package br.com.valkiria.controller;

import br.com.valkiria.model.UserModel;
import br.com.valkiria.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UserModel> create(@RequestBody UserModel userModel){
        return userService.create(userModel);
    }

    @GetMapping("/get/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserModel> getById(@PathVariable("id") UUID id){
        return userService.getById(id);
    }

}
