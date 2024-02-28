package com.todo.list.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import com.todo.list.exception.CannotProcessOperationException;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Task {
    private String title;
    private String description;
    private User personToAssign;
    private TaskState status;
    private LocalDate dueDate;

    public void assignTaskToUser(User user) {
        if (user == null) throw new CannotProcessOperationException("You cannot assign a task to the null person");
        personToAssign = user;
    }

    public void unAssign(){
        personToAssign = null;
    }
}
