package com.example.newproject.controllers.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.newproject.services.impl.UserService;

@RestController
@RequestMapping("/api/users")

public class UserController {
    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }
//    @PostMapping
//    public UserDtoOut createUser(@RequestHeader HttpHeaders headers, @Valid @RequestBody UserDtoIn userDto) {
//        try {
//            User user = userMapper.dtoToObject(userDto);
//            service.create(user);
//            return userMapper.ObjectToDto(user);
//        } catch (EntityDuplicationException | UnsupportedOperationException e) {
//            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
//        }
//    }

}
