package com.GelDisfarce.PI3.Controller;

import com.GelDisfarce.PI3.Model.CadastroFuncionario;
import com.GelDisfarce.PI3.Repository.CadastroFuncionarios;
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
@RequestMapping("/funcionario")
public class FuncionarioController {
    
    @Autowired
    private CadastroFuncionarios CadastroFuncionarios;

    @RequestMapping("/novo")
    public ModelAndView novo() {
        ModelAndView mv = new ModelAndView("CadastroFuncionario");
        mv.addObject(new CadastroFuncionario());
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String salvar(@Validated CadastroFuncionario cadastroFuncionario, Errors errors, RedirectAttributes attributes) {
        if (errors.hasErrors()) {
            return "CadastroFuncionario";
        }
        CadastroFuncionarios.save(cadastroFuncionario);

        attributes.addFlashAttribute("mensagem", "Funcionario Cadastrado com Sucesso!!!");
        return "redirect:/funcionario/novo";
    }

    @RequestMapping
    public ModelAndView ListarFuncionario(@RequestParam(defaultValue = "") String nome) {

        List<CadastroFuncionario> todosFuncionarios = CadastroFuncionarios.findAll();

        ModelAndView mv = new ModelAndView("ListaFuncionario");
        mv.addObject("funcionarios", todosFuncionarios);
        return mv;
    }

    @RequestMapping("{codigo}")
    public ModelAndView edicao(@PathVariable("codigo") Long codigoCadastroFuncionario) {
        CadastroFuncionario cadastroFuncionario = CadastroFuncionarios.getOne(codigoCadastroFuncionario);

        ModelAndView mv = new ModelAndView("CadastroFuncionario");
        mv.addObject(cadastroFuncionario);
        return mv;
    }
    
}
