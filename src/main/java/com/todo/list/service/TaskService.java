package com.todo.list.service;

import lombok.Getter;
import com.todo.list.domain.Task;
import com.todo.list.domain.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
public class TaskService {
    private List<Task> tasks = new ArrayList<>();

    private UserService userService;

    public TaskService(UserService userService) {
        this.userService = userService;
    }

    public void createTask(String taskTitle, String taskDescription, String usernameOfPersonToAssign, LocalDate dueDate){
        //TODO: validate date
        Task newTask;
        if(Objects.equals(usernameOfPersonToAssign, "")){
            newTask = new Task(taskTitle, taskDescription, null, dueDate);
        } else {
            User userToAssign = userService.getUserByUsername(usernameOfPersonToAssign);
            newTask = new Task(taskTitle, taskDescription, userToAssign, dueDate);
        }
        tasks.add(newTask);
    }
}
