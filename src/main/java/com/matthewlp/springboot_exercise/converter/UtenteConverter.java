package com.matthewlp.springboot_exercise.converter;

import com.matthewlp.springboot_exercise.dto.UtenteDTO;
import com.matthewlp.springboot_exercise.entity.Utente;
import jakarta.persistence.Converter;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;




@Component
@AllArgsConstructor
public class UtenteConverter {

    private ModelMapper modelMapper;


    public UtenteDTO convertUtentetoUtenteDTO(Utente utente){

        return modelMapper.map(utente, UtenteDTO.class);
    }

    public Utente convertUtenteDTOtoUtente(UtenteDTO utenteDTO){

        return modelMapper.map(utenteDTO, Utente.class);
    }

}
