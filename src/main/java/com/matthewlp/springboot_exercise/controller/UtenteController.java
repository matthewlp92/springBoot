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

    @GetMapping("/users/email/{email}")
    public Utente getUtenteByEmail(@PathVariable("email") String email){

        return utenteService.getUtenteByEmail(email);
    }

    @PostMapping("/users")
    public Utente addUtente(@RequestBody Utente u){

        return utenteService.saveUtente(u);

    }
    @PutMapping("/users/{id}")
    public Utente updateUtenteById(@PathVariable("id") long id, @RequestBody Utente updateUser) throws Exception {

        return utenteService.updateUtenteById(id,updateUser);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUtenteById(@PathVariable("id") long id){
        log.info("Utente "+ utenteService.getUtenteById(id).getUsername()+ " è stato eliminato");
        utenteService.deleteUtenteById(id);
    }
}
