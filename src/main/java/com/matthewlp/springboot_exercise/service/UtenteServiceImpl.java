package com.matthewlp.springboot_exercise.service;

import com.matthewlp.springboot_exercise.converter.UtenteConverter;
import com.matthewlp.springboot_exercise.dto.CreateUtenteRequestDTO;
import com.matthewlp.springboot_exercise.dto.UpdateUtenteRequestDTO;
import com.matthewlp.springboot_exercise.dto.UtenteDTO;
import com.matthewlp.springboot_exercise.entity.Utente;
import com.matthewlp.springboot_exercise.repository.UtenteRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class UtenteServiceImpl implements UtenteService{

    @Autowired
    private UtenteRepo utenteRepo;

    @Autowired
    private UtenteConverter utenteConverter;


    public List<UtenteDTO> getListaUtenti(){

        List<Utente> utenti = utenteRepo.findAll();

        return utenti.stream().map(utente -> utenteConverter.convertUtentetoUtenteDTO(utente)).collect(Collectors.toList());
    }


    public UtenteDTO getUtenteById(long id) {

        Utente utente = utenteRepo.findById(id).orElse(null);

        if(utente != null){

            return utenteConverter.convertUtentetoUtenteDTO(utente);
        }

        return null;

    }

    public UtenteDTO crateUtente(CreateUtenteRequestDTO createUtenteRequestDTO) {
        Utente utente = new Utente();

        utente.setUsername(createUtenteRequestDTO.getUsername());
        utente.setPassword(createUtenteRequestDTO.getPassword());
        utente.setEmail(createUtenteRequestDTO.getEmail());

        utente = utenteRepo.save(utente);

        return  utenteConverter.convertUtentetoUtenteDTO(utente);
    }

    public UtenteDTO getUtenteByEmail(String email){

        Utente utente = utenteRepo.findUtenteByEmail(email);

        if(utente != null){

            return utenteConverter.convertUtentetoUtenteDTO(utente);
        }

        return null;
    }



    public UtenteDTO updateUtenteById(long id, UpdateUtenteRequestDTO updateUtenteRequestDTO) {

        Utente utenteEsistente = utenteRepo.findById(id).orElse(null);

        if(utenteEsistente != null){

            utenteEsistente.setUsername(updateUtenteRequestDTO.getUsername());
            utenteEsistente.setPassword(updateUtenteRequestDTO.getPassword());
            utenteEsistente.setEmail(updateUtenteRequestDTO.getEmail());

            utenteRepo.save(utenteEsistente);

            return utenteConverter.convertUtentetoUtenteDTO(utenteEsistente);
        }

        return null;
    }

    public UtenteDTO deleteUtenteById(long id){

        Utente utente = utenteRepo.findById(id).orElse(null);

        if(utente != null){

            utenteRepo.deleteById(id);

            return utenteConverter.convertUtentetoUtenteDTO(utente);
        }

        return null;

    };




}
