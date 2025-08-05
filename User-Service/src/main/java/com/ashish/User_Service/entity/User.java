package com.ashish.User_Service.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name can not blank")
    @Column(unique = true, nullable = false)
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "invalid email format")
    @Column(unique = true)
    private String email;


    @NotBlank(message = "password can not blank")
    @Size(min=6, message = "password must be at least 6 characters")
    private String password;


    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
    @Column(unique = true)
    private String phone;

}
