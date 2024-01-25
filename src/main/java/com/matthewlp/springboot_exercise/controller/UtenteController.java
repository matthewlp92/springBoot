package com.matthewlp.springboot_exercise.controller;

import com.matthewlp.springboot_exercise.entity.Utente;
import com.matthewlp.springboot_exercise.service.UtenteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/esercizio/api")
@Slf4j
public class UtenteController {


    @Autowired
    private UtenteService utenteService;

    @Operation(summary = "Torna la lista degli utenti, se presenti")
    @GetMapping("/users")
    public ResponseEntity<?> getListaUtenti(){

        List<Utente> listaUtenti = utenteService.getListaUtenti();

        return ResponseEntity.status(HttpStatus.OK).body(listaUtenti);
    }
    @Operation(summary = "Torna un utente in base al suo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Utente trovato", content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Utente.class)) }),
            @ApiResponse(responseCode = "400", description = "Id non valido", content = @Content),
            @ApiResponse(responseCode = "404", description = "Utente non trovato", content = @Content),
    })
    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUtenteById(@Parameter(description = "id dell'utente da cercare") @PathVariable("id") long id){

        log.info("getUtenteById started");

        Utente u = utenteService.getUtenteById(id);

        log.info("getUserById Completed");

        if(u != null){

            return ResponseEntity.status(HttpStatus.OK).body(u);
        }else{

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{}");
        }
    }
    @Operation(summary = "Torna un utente in base alla sua email")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Utente trovato", content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Utente.class)) }),
            @ApiResponse(responseCode = "400", description = "mail non valida", content = @Content),
            @ApiResponse(responseCode = "404", description = "Utente non trovato", content = @Content),
    })
    @GetMapping("/users/email/{email}")
    public Utente getUtenteByEmail(@Parameter(description = "email dell'utente da cercare")@PathVariable("email") String email){

        return utenteService.getUtenteByEmail(email);
    }
    @Operation(summary = "Aggiunge un utente")
    @PostMapping("/users")
    public Utente addUtente(@RequestBody Utente u){

        return utenteService.saveUtente(u);

    }
    @Operation(summary = "Aggiorna un utente in base al suo ID")
    @PutMapping("/users/{id}")
    public Utente updateUtenteById(@PathVariable("id") long id, @RequestBody Utente updateUser) throws Exception {

        return utenteService.updateUtenteById(id,updateUser);
    }

    @Operation(summary = "Elimina un utente in base al suo ID")
    @DeleteMapping("/users/{id}")
    public void deleteUtenteById(@PathVariable("id") long id){
        log.info("Utente "+ utenteService.getUtenteById(id).getUsername()+ " è stato eliminato");
        utenteService.deleteUtenteById(id);
    }
}
