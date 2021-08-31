package com.example.demo;

import lombok.Data;

import java.io.Serializable;

@Data
public class User  {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
