package br.edu.fatec.projetoExemplo_Noite.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//tranformando a classe em um bean do tipo controller MVC
@Controller
//mapeando a URL de acesso ao controller e aos métodos contidos nele
@RequestMapping("/funcionarios")
public class FuncionarioController {

    //mapeando o acesso ao método cadastrar
    @GetMapping("/cadastrar")
    public String cadastrar() {
        return "/funcionario/cadastro";
    }

    //mapeando o acesso ao método listar
    @GetMapping("/listar")
    public String listar() {
        return "/funcionario/lista";
    }
}