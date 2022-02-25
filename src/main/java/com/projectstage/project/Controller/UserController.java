package com.projectstage.project.Controller;

import java.util.List;

import com.projectstage.project.Entities.User;
import com.projectstage.project.Services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user")
    public List<User> allUser(){
        return userService.getAllUserList();
    }

    @RequestMapping("/user/{id}")
    public User getUser(@PathVariable("id") String id){
        return userService.getUser(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/user")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/user/{id}")
    public void updateUser(@RequestBody User user, @PathVariable("id")String id){
        userService.updateUser(user, id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/user/{id}")
    public void deleteUser(@PathVariable("id")String id){
        userService.deleteUser(id);
    }
}
