package com.suporte.SiteWebSuporte.controller;

import java.util.List;

import com.suporte.SiteWebSuporte.model.Chamado;
import com.suporte.SiteWebSuporte.model.Procedimento;
import com.suporte.SiteWebSuporte.repository.ChamadoRepositorio;
import com.suporte.SiteWebSuporte.repository.ProcedimentoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ChamadoController {
    @Autowired
    private ChamadoRepositorio chamadoRepositorio;
    @Autowired
    private ProcedimentoRepositorio procedimentoRepositorio;

    // * Acessa a lista de chamados pelo visitante* //
    @GetMapping("/ListaChamados")
    public String ListaChamados(Model model) {
        List<Chamado> chamado = (List<Chamado>) chamadoRepositorio.findAll();
        model.addAttribute("listChamados", chamado);
        return "ListaChamados";
    }

    // * Recebe o form do html *//
    @PostMapping(path = "/addChamado")
    public String novoChamado(@Validated Chamado chamado, BindingResult result) {

        if (result.hasFieldErrors()) {
            return "redirect:/403";
        }
        chamadoRepositorio.save(chamado);
        return "redirect:/ListaChamados";
    }

    // ** Mostrar os campos do chaamado no forma para editar */
    @GetMapping(path = "/EditarChamado/{id}")
    public String editarChamado(@PathVariable(value = "id") long id, Model model) {

        // get employee from the service
        Chamado chamado = chamadoRepositorio.findById(id).get();

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("chamado", chamado);

        // Mostra a lista de procedimentos no campo input, para alterar a procedimento
        // do chamado
        List<Procedimento> ListaID_Procedimentos = (List<Procedimento>) procedimentoRepositorio.findAll();
        model.addAttribute("ListaID_Procedimentos", ListaID_Procedimentos);

        System.out.println("id: " + id);

        return "EditarChamado";
    }

    // ** Realizar a alteracao dos dados do chamado dentro do form */
    @PostMapping("/atualizarChamado/{id}")
    public String updateChamado(@PathVariable("id") long id, @Validated Chamado chamado,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            chamado.setId(id);
            return "EditarChamado";
        }

        chamadoRepositorio.save(chamado);
        return "redirect:/ListaChamados";
    }

    // Abrir a selecao de de KBS existentes no input do "procedimentoUsado" */
    @RequestMapping(value = ("/NovoChamado"), method = RequestMethod.GET)
    public String NovoChamado(Model model) {

        List<Procedimento> ListaID_Procedimentos = (List<Procedimento>) procedimentoRepositorio.findAll();
        model.addAttribute("ListaID_Procedimentos", ListaID_Procedimentos);
        System.out.println("lol" + ListaID_Procedimentos);
        return "/NovoChamado";
    }

}
