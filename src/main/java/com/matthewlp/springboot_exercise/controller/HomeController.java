package com.matthewlp.springboot_exercise.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class HomeController {
    @GetMapping("/")
    public String landingPage(Model model) {
        try {
            // Logica del tuo metodo
            // Aggiungi il messaggio di benvenuto al modello
            model.addAttribute("welcomeMessage", "Benvenuto nella home page!");

            System.out.print("---------------SONO NELLA HOME--------------------");

            return "landing";
        } catch (Exception e) {
            // Gestione delle eccezioni

            model.addAttribute("errorMessage", "Si è verificato un errore.");

            // Puoi anche loggare l'eccezione per una migliore diagnostica

            return "error";
        }
    }
    @GetMapping("/nextPage")
    public String nextPage(Model model) {
        try {

            return "redirect:/esercizio/api/users";

        }catch (Exception e){

            model.addAttribute("errorMessage", "Si è verificato un errore.");

            return "error";
        }


    }

}
