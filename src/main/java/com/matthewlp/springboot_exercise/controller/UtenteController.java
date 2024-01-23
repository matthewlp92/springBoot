package com.matthewlp.springboot_exercise.controller;

import com.matthewlp.springboot_exercise.entity.Utente;
import com.matthewlp.springboot_exercise.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UtenteController {

    @Autowired
    private UtenteService utenteService;
    @PostMapping("/addUtente")
    public Utente addUtente(@RequestBody Utente u){

        return utenteService.saveUtente(u);

    }
}
