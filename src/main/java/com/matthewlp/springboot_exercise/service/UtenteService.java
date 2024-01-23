package com.matthewlp.springboot_exercise.service;

import com.matthewlp.springboot_exercise.entity.Utente;
import com.matthewlp.springboot_exercise.repository.UtenteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

        return utenteRepo.findUtenteById(id);
    }
}
