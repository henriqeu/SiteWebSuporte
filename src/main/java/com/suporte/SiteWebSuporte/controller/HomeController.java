package com.suporte.SiteWebSuporte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

import com.suporte.SiteWebSuporte.model.Procedimento;
import com.suporte.SiteWebSuporte.repository.ProcedimentoRepositorio;

@Controller
public class HomeController {
    @Autowired // ela serv para nos comunicar com UserRepository
    private ProcedimentoRepositorio procedimentoRepositorio;

    // * Mapeando o endereco */
    @GetMapping("/")
    public String index(Model model) {
        List<Procedimento> textoKB = (List<Procedimento>) procedimentoRepositorio.findAll();
        model.addAttribute("listProcedimentos", textoKB);
        return "ListaProcedimentos";
    }

    // * Mapeando o endereco para o acessar a pagina do form de registro de
    // procedimentos */
    @GetMapping("/NovoProcedimento")
    public String form() {
        return "NovoProcedimento";
    }

    // * Procedimento para adicionar os campos do form */
    @PostMapping(path = "/add")
    public String novoProcedimento(@Validated Procedimento procedimento, BindingResult result) {
        if (result.hasFieldErrors()) {
            return "redirect:/";
        }
        procedimentoRepositorio.save(procedimento);
        return "redirect:/";
    }

    // * Procedimento visualizar todos os procedimentos com crud */
    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Procedimento> allText() {
        return procedimentoRepositorio.findAll();
    }

    // * Procedimento para mostrar os dados do procedimento para realizar alterção
    // */
    @GetMapping("/EditarProcedimento/{id}")
    public String EditarProcedimento(@PathVariable(value = "id") long id, Model model) {

        // get employee from the service
        Procedimento procedimento = procedimentoRepositorio.findById(id).get();

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("procedimento", procedimento);

        System.out.println("id: " + id);

        return "EditarProcedimento";
    }

    @PostMapping("/atualizarProcedimento/{id}")
    public String atualizarProcedimento(@PathVariable("id") long id, @Validated Procedimento procedimento,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            procedimento.setId(id);
            return "EditarProcedimento";
        }

        procedimentoRepositorio.save(procedimento);
        return "redirect:/";
    }

    // * Procedimento para o usuario visitante visualizar o procedimento */
    @GetMapping("/MostrarProcedimento/{id}")
    public String mostrarProcedimento(@PathVariable(value = "id") long id, Model model) {
        // get employee from the service
        Procedimento p = procedimentoRepositorio.findById(id).get();

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("procedimento", p);

        return "MostrarProcedimento";
    }

}
