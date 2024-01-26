package com.matthewlp.springboot_exercise.dto;

import lombok.Data;

@Data
public class UpdateUtenteRequestDTO {

    private String username;
    private String password;
    private String email;
}
