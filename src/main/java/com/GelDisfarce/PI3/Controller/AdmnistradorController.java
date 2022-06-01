package com.GelDisfarce.PI3.Controller;

import com.GelDisfarce.PI3.Model.CadastroAdministrador;
import com.GelDisfarce.PI3.Repository.CadastroAdministradores;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author jardel
 */
@Controller
@RequestMapping("/administrador")
public class AdmnistradorController {

    @Autowired
    private CadastroAdministradores CadastroAdministradores;

    @RequestMapping("/novo")
    public ModelAndView novo() {
        ModelAndView mv = new ModelAndView("CadastroAdministrador");
        mv.addObject(new CadastroAdministrador());
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String salvar(@Validated CadastroAdministrador cadastroAdministrador, Errors errors, RedirectAttributes attributes) {
        if (errors.hasErrors()) {
            return "CadastroAdministrador";
        }
        CadastroAdministradores.save(cadastroAdministrador);

        attributes.addFlashAttribute("mensagem", "Administrador Cadastrado com Sucesso!!!");
        return "redirect:/administrador/novo";
    }

    @RequestMapping
    public ModelAndView ListarAdminsitrador(@RequestParam(defaultValue = "") String nome) {

        List<CadastroAdministrador> todosAdministradores = CadastroAdministradores.findAll();

        ModelAndView mv = new ModelAndView("ListaAdministrador");
        mv.addObject("administradores", todosAdministradores);
        return mv;
    }

    @RequestMapping("{codigo}")
    public ModelAndView edicao(@PathVariable("codigo") Long codigoCadastroAdministrador) {
        CadastroAdministrador cadastroAdministrador = CadastroAdministradores.getOne(codigoCadastroAdministrador);

        ModelAndView mv = new ModelAndView("CadastroAdministrador");
        mv.addObject(cadastroAdministrador);
        return mv;
    }

    @RequestMapping(value = "{codigo}", method = RequestMethod.DELETE)
    public String excluir(@PathVariable Long codigo, RedirectAttributes attributes) {
        CadastroAdministradores.deleteById(codigo);

        attributes.addFlashAttribute("mensagem", "Adminstrador excluído com sucesso!");
        return "redirect:/administrador";
    }   
    
}

