package com.matthewlp.springboot_exercise.controller;

import com.matthewlp.springboot_exercise.entity.Utente;
import com.matthewlp.springboot_exercise.service.UtenteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/esercizio/api")
@Api(tags = "Utente Controller", description = "Operazioni sugli utenti")
public class UtenteController {

    @Autowired
    private UtenteService utenteService;
    @GetMapping("/users")
    public List<Utente> getListaUtenti(){

        return utenteService.getListaUtenti();
    }
    @GetMapping("/users/{id}")
    @ApiOperation(value = "Trova utente per ID", notes = "Fornisce dettagli dell' utente con ID specificato")
    public Utente getUtenteById(@PathVariable("id") long id){

        return utenteService.getUtenteById(id);
    }

    @PostMapping("/users")
    public Utente addUtente(@RequestBody Utente u){

        return utenteService.saveUtente(u);

    }
}
