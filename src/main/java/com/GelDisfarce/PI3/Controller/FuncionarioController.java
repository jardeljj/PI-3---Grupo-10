package com.GelDisfarce.PI3.Controller;

import com.GelDisfarce.PI3.Model.CadastroFuncionario;
import com.GelDisfarce.PI3.Model.TipoFuncao;
import com.GelDisfarce.PI3.Repository.CadastroFuncionarios;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    
    private static final String CADASTRO_VIEW = "CadastroFuncionario";
    
    @Autowired
    private CadastroFuncionarios CadastroFuncionarios;

    @RequestMapping("/novo")
    public ModelAndView novo() {
        ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
        mv.addObject("todosTiposFuncao", TipoFuncao.values());
        mv.addObject(new CadastroFuncionario());
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String salvar(@Validated CadastroFuncionario cadastroFuncionario, Errors errors, RedirectAttributes attributes) {
        if (errors.hasErrors()) {
            return CADASTRO_VIEW;
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

        ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
        mv.addObject(cadastroFuncionario);
        return mv;
    }
    
     @RequestMapping(value = "{codigo}", method = RequestMethod.DELETE)
    public String excluir(@PathVariable Long codigo, RedirectAttributes attributes) {
        CadastroFuncionarios.deleteById(codigo);

        attributes.addFlashAttribute("mensagem", "Funcionário excluído com sucesso!");
        return "redirect:/funcionario";
    }
    
    @ModelAttribute("todosTiposFuncao")
    public List<TipoFuncao> todosTiposFuncao() {
        return Arrays.asList(TipoFuncao.values());
    }   
    
}
