package com.todo.list.domain;

import lombok.*;
import com.todo.list.exception.CannotProcessOperationException;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private String username;
    private String firstName;
    private String lastName;

    public void setFirstName(String firstName) {
        if (firstName.length() < 3) throw new CannotProcessOperationException("First name is too short");
        this.firstName = firstName;
    }
}
