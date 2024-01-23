package com.matthewlp.springboot_exercise.service;

import com.matthewlp.springboot_exercise.entity.Utente;
import com.matthewlp.springboot_exercise.repository.UtenteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtenteService {

    @Autowired
    private UtenteRepo utenteRepo;

    public Utente saveUtente(Utente u){

        return utenteRepo.save(u);
    }
}
