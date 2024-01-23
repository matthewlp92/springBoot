package com.matthewlp.springboot_exercise.controller;

import com.matthewlp.springboot_exercise.entity.Utente;
import com.matthewlp.springboot_exercise.service.UtenteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/esercizio/api")
@Slf4j
public class UtenteController {

    @Autowired
    private UtenteService utenteService;
    @GetMapping("/users")
    public List<Utente> getListaUtenti(){

        return utenteService.getListaUtenti();
    }
    @GetMapping("/users/{id}")
    public Utente getUtenteById(@PathVariable("id") long id){

        return utenteService.getUtenteById(id);
    }

    @PostMapping("/users")
    public Utente addUtente(@RequestBody Utente u){

        return utenteService.saveUtente(u);

    }
}
