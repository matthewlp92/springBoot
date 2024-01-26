package com.matthewlp.springboot_exercise.controller;

import com.matthewlp.springboot_exercise.dto.CreateUtenteRequestDTO;
import com.matthewlp.springboot_exercise.dto.UpdateUtenteRequestDTO;
import com.matthewlp.springboot_exercise.dto.UtenteDTO;
import com.matthewlp.springboot_exercise.entity.Utente;
import com.matthewlp.springboot_exercise.service.UtenteService;
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

        List<UtenteDTO> listaUtenti = utenteService.getListaUtenti();

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

        UtenteDTO u = utenteService.getUtenteById(id);

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
    public ResponseEntity<?> getUtenteByEmail(@Parameter(description = "email dell'utente da cercare")@PathVariable("email") String email){

        log.info("getUtenteByEmail started");

        UtenteDTO u = utenteService.getUtenteByEmail(email);

        log.info("getUserByEmail Completed");

        if(u != null){

            return ResponseEntity.status(HttpStatus.OK).body(u);
        }else{

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{}");
        }
    }
    @Operation(summary = "Aggiunge un utente")
    @PostMapping("/users")
    public ResponseEntity<?> createUtente(@RequestBody CreateUtenteRequestDTO createUtenteRequestDTO){

        UtenteDTO utenteDTO = utenteService.crateUtente(createUtenteRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(utenteDTO);

    }
    @Operation(summary = "Aggiorna un utente in base al suo ID")
    @PutMapping("/users/{id}")
    public ResponseEntity<?> updateUtenteById(@PathVariable("id") long id, @RequestBody UpdateUtenteRequestDTO updateUtenteRequestDTO){

        UtenteDTO utenteDTO = utenteService.updateUtenteById(id,updateUtenteRequestDTO);

        if (utenteDTO != null) {
            return ResponseEntity.status(HttpStatus.OK).body(utenteDTO);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{}");
        }
    }

    @Operation(summary = "Elimina un utente in base al suo ID")
    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUtenteById(@PathVariable("id") long id){

        UtenteDTO utenteDTO = utenteService.deleteUtenteById(id);

        if (utenteDTO != null) {
            return ResponseEntity.status(HttpStatus.OK).body(utenteDTO);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{}");
        }

    }
}
