package com.example.UserManagementSystem.controller;

import com.example.UserManagementSystem.model.User;
import com.example.UserManagementSystem.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user-management-system")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("find-all")
    public List<User> findAllUser() {
        return userService.findAllUser();
    }

    @PostMapping("add-user")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);

    }


    @GetMapping("find-user/id/{id}")
    public User findUser(@PathVariable int id) {
        return userService.findById(id);
    }
    @PutMapping("update-user")
    public void updateUser(@PathVariable int id, @RequestBody User user) {
        userService.updateUser(id, user);
    }
    @DeleteMapping("delete-user/id/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }


}
