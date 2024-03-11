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
    private LocalDate creationDate;
    private LocalDate dueDate;

//    public Task(String title) {
//        this.title = title;
//        this.status = TaskState.TODO;
//        this.creationDate = LocalDate.now();
//    }

    public Task(String title, String description, User personToAssign, LocalDate dueDate) {
        this.title = title;
        this.description = description;
        this.personToAssign = personToAssign;
        this.status = TaskState.TODO;
        this.creationDate = LocalDate.now();
        this.dueDate = dueDate;
    }

    public void assignTaskToUser(User user) {
        if (user == null) throw new CannotProcessOperationException("You cannot assign a task to the null person");
        personToAssign = user;
    }

    public void unAssign(){
        personToAssign = null;
    }
}
