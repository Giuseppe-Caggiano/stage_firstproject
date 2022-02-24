package com.projectstage.project.Services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.projectstage.project.Entities.User;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private List<User> userList = new ArrayList<>(Arrays.asList(

            new User("1", "Giuseppe", "Caggiano","gc@gmail.com"),
            new User("2", "a", "b","ab@gmail.com"),
            new User("3", "c", "d","cd@gmail.com")

    ));

    public List<User> getAllUserList() {
        return this.userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public User getUser(String id){
        return userList.stream().filter(User -> User.getId().equals(id)).findFirst().get();
    }

    public void addUser(User user){
        userList.add(user);
    }

    public void updateUser(User user,String id){
        int counter = 0;
        for (User user1 : userList) {
            if (user1.getId().equals(id)){
                userList.set(counter, user);
            }
            counter ++;
        }
    }

    public void deleteUser(String id) {
        userList.removeIf(User -> User.getId().equals(id));
        }
    
}
