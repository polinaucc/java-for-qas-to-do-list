package com.todo.list.service;

import lombok.Getter;
import com.todo.list.domain.User;
import com.todo.list.exception.CannotProcessOperationException;
import com.todo.list.exception.NotFoundException;

import java.util.ArrayList;
import java.util.List;

@Getter
public class UserService {

    private List<User> users = new ArrayList<>();

    public void addUser(User user) {
        if (users.size() == 5) throw new CannotProcessOperationException("User amount is 5 max");
        users.add(user);
    }

    public List<String> getAllUsernames(){
       return users.stream().map(User::getUsername).toList();
    }

    public User getUserByUsername(String username) {
        return users.stream()
                .filter(user -> user.getUsername().equals(username)).findFirst()
                .orElseThrow(() -> new NotFoundException("User with username: " + username + " was not found"));
    }

}
