package com.todo.list.domain;

import lombok.Getter;
import com.todo.list.exception.CannotProcessOperationException;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ToDoProgram {

    private List<User> users = new ArrayList<>();

    public void addUser(User user) {
        if (users.size() == 5)
            throw new CannotProcessOperationException("User amount is 5 max");
        users.add(user);
    }
}
