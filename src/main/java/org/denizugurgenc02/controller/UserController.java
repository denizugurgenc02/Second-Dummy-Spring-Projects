package org.denizugurgenc02.controller;

import org.denizugurgenc02.dto.UserRequestDTO;
import org.denizugurgenc02.dto.UserResponseDTO;
import org.denizugurgenc02.entities.User;
import org.denizugurgenc02.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(path = "/add")
    public UserResponseDTO addUser(@RequestBody UserRequestDTO user) {
        return userService.addUser(user);
    }

    @GetMapping(path = "/{id}")
    public UserResponseDTO getUser(@PathVariable(value = "id") Integer id) {
        return userService.getUser(id);
    }

    @DeleteMapping(path = "/{id}")
    public Boolean deleteUser(@PathVariable(value = "id") Integer id) {
        return userService.deleteUser(id);
    }

    @PutMapping(path = "/{id}")
    public UserResponseDTO updateUser(@PathVariable(value = "id") Integer id, @RequestBody UserRequestDTO newUser) {
        return userService.updateUser(id, newUser);
    }

    @GetMapping(path = "/list")
    public List<UserResponseDTO> getUserList() {
        return userService.getUserList();
    }
}
