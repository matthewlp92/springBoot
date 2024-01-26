package com.matthewlp.springboot_exercise.repository;

import com.matthewlp.springboot_exercise.entity.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteRepo extends JpaRepository<Utente,Long> {

    Utente findUtenteByEmail(String email);


}
