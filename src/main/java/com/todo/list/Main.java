package com.todo.list;

import com.todo.list.service.UserService;
import com.todo.list.domain.User;
import com.todo.list.exception.NotFoundException;
import com.todo.list.service.TaskService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * TODO:
 * - refactor case 1
 * - check negative cases and fix them
 * - case 3: change task status (TODO -> IN_PROGRESS/CANCELLED, IN_PROGRESS -> DONE)
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserService();
        TaskService taskService = new TaskService(userService);

        System.out.println("Choose an option");

        while (true) {
            System.out.println("Press 1 to create a user");
            System.out.println("Press 2 to create a task");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    runCreateUserFlow(scanner, userService);
                    break;
                case 2:
                    try {
                        scanner.nextLine();

                        System.out.println("Enter title of the task: ");
                        String taskTitle = scanner.nextLine();

                        System.out.println("Enter description:");
                        String taskDescription = scanner.nextLine();

                        System.out.println("Enter due date in format dd.MM.yyyy:");
                        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                        String dueDateFromConsole = scanner.nextLine();
                        LocalDate dueDate = LocalDate.parse(dueDateFromConsole, dateTimeFormatter);

                        System.out.println("Enter username of a person to assign");
                        System.out.println(userService.getAllUsernames());
                        String usernameOfPersonToAssign = scanner.nextLine();

                        taskService.createTask(taskTitle, taskDescription, usernameOfPersonToAssign, dueDate);
                        System.out.println(taskService.getTasks());
                    } catch (NotFoundException notFoundException) {
                        System.out.println("Something went wrong. Try again");
                    }
                    break;
                default:
                    System.out.println("Ooops");
                    return;

            }
        }
    }

    private static void runCreateUserFlow(Scanner scanner, UserService userService) {
        scanner.nextLine();
        User userFromConsole = new User();

        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        userFromConsole.setUsername(username);

        System.out.println("Enter first name: ");
        String firstName = scanner.nextLine();
        userFromConsole.setFirstName(firstName);

        System.out.println("Enter last name: ");
        String lastName = scanner.nextLine();
        userFromConsole.setLastName(lastName);

        userService.addUser(userFromConsole);
        System.out.println(userService.getUsers());
    }
}

