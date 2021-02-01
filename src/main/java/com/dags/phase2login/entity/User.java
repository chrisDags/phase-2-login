package com.dags.phase2login.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor
public class User {

    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    /*
        The username and password must between 3 and 32 characters long. This is technically already handled in the JSP
        files, so this is defensive programming. The user SHOULDN'T be able input anything outside the range of 3 - 32,
        but its a good idea to verify on the backend.
     */

    /*
        PLEASE NOTE:

        The instructions did not specify how long the username and password should be, nor did they specify
        whether or not the username can contain letters and symbols and numbers, so I decided to allow anything as long
        as it is between 3 and 32 characters long.
     */
    @Column
    @NotBlank
    @Length(min = 3, max = 32)
    private String username;

    @Column
    @NotBlank
    @Length(min = 3, max = 32)
    private String password;


}
