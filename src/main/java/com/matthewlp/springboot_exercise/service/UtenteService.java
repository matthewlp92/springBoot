package com.matthewlp.springboot_exercise.service;

import com.matthewlp.springboot_exercise.entity.Utente;
import com.matthewlp.springboot_exercise.repository.UtenteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponse;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UtenteService {

    @Autowired
    private UtenteRepo utenteRepo;

    public Utente saveUtente(Utente u){

        return utenteRepo.save(u);
    }

    public List<Utente> getListaUtenti(){

        return utenteRepo.findAll();
    }


    public Utente getUtenteById(long id) {

        Utente u = utenteRepo.findUtenteById(id);

        if(u != null){

            return u;
        }else{

            throw new ResponseStatusException(HttpStatusCode.valueOf(404));
        }


    }

    public Utente getUtenteByEmail(String email){

        return utenteRepo.findUtenteByEmail(email);
    }

    public void deleteUtenteById(long id){

        utenteRepo.deleteById(id);
    };

    public Utente updateUtenteById(long id , Utente updateUtente) throws Exception {

       Utente utenteEsistente = utenteRepo.findUtenteById(id);

       if(utenteEsistente == null){

           throw new Exception("Utente non trovato");

       }

       utenteEsistente.setUsername(updateUtente.getUsername());
       utenteEsistente.setPassword(updateUtente.getPassword());
       utenteEsistente.setEmail(updateUtente.getEmail());

       return utenteRepo.save(utenteEsistente);

    }
}
