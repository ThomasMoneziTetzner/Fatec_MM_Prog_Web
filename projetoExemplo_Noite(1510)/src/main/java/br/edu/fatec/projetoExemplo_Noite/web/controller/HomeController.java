package br.edu.fatec.projetoExemplo_Noite.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//tranformando a classe em um bean do tipo controller MVC
@Controller
public class HomeController {

    //mapeando o acesso ao método home
    @GetMapping("/")
    public String home() {
        return "/home";
    }
}


