package com.todo.list;

import com.todo.list.domain.ToDoProgram;
import com.todo.list.domain.User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ToDoProgram toDoProgram = new ToDoProgram();

        System.out.println("Choose an option");

        while (true) {
            System.out.println("Press 1 to create a user");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
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

                    toDoProgram.addUser(userFromConsole);
                    System.out.println(toDoProgram.getUsers());
                    break;

                default:
                    System.out.println("Ooops");
                    return;

            }
        }
    }
}

