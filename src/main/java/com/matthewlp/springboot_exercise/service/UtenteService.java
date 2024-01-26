package com.matthewlp.springboot_exercise.service;

import com.matthewlp.springboot_exercise.dto.CreateUtenteRequestDTO;
import com.matthewlp.springboot_exercise.dto.UpdateUtenteRequestDTO;
import com.matthewlp.springboot_exercise.dto.UtenteDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UtenteService {

    public List<UtenteDTO> getListaUtenti();

    public UtenteDTO getUtenteByEmail(String email);

    public UtenteDTO getUtenteById(long id);

    public UtenteDTO crateUtente(CreateUtenteRequestDTO createUtenteRequestDTO);

    public UtenteDTO updateUtenteById (long id, UpdateUtenteRequestDTO updateUtenteRequestDTO);

    public UtenteDTO deleteUtenteById(long id);


}
