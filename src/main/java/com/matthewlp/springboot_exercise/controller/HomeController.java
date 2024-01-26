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

            model.addAttribute("welcomeMessage", "Benvenuto nella home page dell'esercizietto!");

            System.out.print("---------------SONO NELLA HOME--------------------");

            return "landing";
        } catch (Exception e) {

            model.addAttribute("errorMessage", "Si è verificato un errore.");


            return "error";
        }
    }
    @GetMapping("/nextPage")
    public String nextPage(Model model) {
        try {

            return "redirect:/swagger-ui.html";

        }catch (Exception e){

            model.addAttribute("errorMessage", "Si è verificato un errore.");

            return "error";
        }


    }

}
