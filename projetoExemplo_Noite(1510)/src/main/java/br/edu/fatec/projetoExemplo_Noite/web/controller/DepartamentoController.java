package br.edu.fatec.projetoExemplo_Noite.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//tranformando a classe em um bean do tipo controller MVC
@Controller
//mapeando a URL de acesso ao controller e aos métodos contidos nele
@RequestMapping("/departamentos")
public class DepartamentoController {

    //informando ao Spring que ele deve injetar a variável anotada
    // na classe em que está declarada
    @Autowired
    private DepartamentoService service;

    //mapeando o acesso ao método cadastrar
    @GetMapping("/cadastrar")
    public String cadastrar(Departamento departamento) {
        return "/departamento/cadastro";
    }

    //mapeando o acesso ao método listar
    @GetMapping("/listar")
    public String listar(ModelMap model) {
        model.addAttribute("departamentos", service.buscarTodos());
        return "/departamento/lista";
    }

    //mapeando o acesso ao método salvar
    @PostMapping("/salvar")
    public String salvar(Departamento departamento, RedirectAttributes attr) {
        service.salvar(departamento);
        attr.addFlashAttribute("success", "Departamento inserido com sucesso.");
        return "redirect:/departamentos/cadastrar";
    }

    //mapeando o acesso ao método preEditar
    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("departamento", service.buscarPorId(id));
        return "/departamento/cadastro";
    }

    //mapeando o acesso ao método editar
    @PostMapping("/editar")
    public String editar(Departamento departamento, RedirectAttributes attr) {
        service.editar(departamento);
        attr.addFlashAttribute("success", "Departamento editado com sucesso.");
        return "redirect:/departamentos/cadastrar";
    }

    //mapeando o acesso ao método excluir
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, ModelMap model) {

        if (service.depertamentoTemCargos(id)) {
            model.addAttribute("fail",
                    "Departamento não removido. Possui cargo(s) vinculado(s).");
        } else {
            service.excluir(id);
            model.addAttribute("success",
                    "Departamento excluído com sucesso.");
        }

        return listar(model);
    }
}
