package com.GelDisfarce.PI3.Controller;

import com.GelDisfarce.PI3.Model.CadastroCliente;
import com.GelDisfarce.PI3.Model.StatusCliente;
import com.GelDisfarce.PI3.Repository.CadastroClientes;
import com.GelDisfarce.PI3.Repository.filter.CadastroClienteFilter;
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
@RequestMapping("/cadastro")
public class ClienteController {
    
    private static final String CADASTRO_VIEW = "CadastroCliente";

    @Autowired
    private CadastroClientes CadastroClientes;

    @RequestMapping("/cliente")
    public ModelAndView novo() {
        ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
        mv.addObject("todosStatusCadastro", StatusCliente.values());
        mv.addObject(new CadastroCliente());
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String salvar(@Validated CadastroCliente cadastroCliente, Errors errors, RedirectAttributes attributes) {
        if (errors.hasErrors()) {
            return CADASTRO_VIEW;
        }
        CadastroClientes.save(cadastroCliente);

        attributes.addFlashAttribute("mensagem", "Cliente Cadastrado com Sucesso!!!");
        return "redirect:/cadastro/cliente";
    }

    @RequestMapping
    public ModelAndView ListarCliente(@RequestParam(defaultValue = "") String nome) {
      
        List<CadastroCliente> todosClientes = CadastroClientes.findAll();
        
        
        ModelAndView mv = new ModelAndView("ListaCliente");
        mv.addObject("clientes", todosClientes);
        return mv;
    }

    @RequestMapping("{codigo}")
    public ModelAndView edicao(@PathVariable("codigo") Long codigoCadastroCliente) {
	CadastroCliente cadastroCliente = CadastroClientes.getOne(codigoCadastroCliente);
	
	ModelAndView mv = new ModelAndView(CADASTRO_VIEW); 
	mv.addObject(cadastroCliente);
	return mv;
}
    
    
    
    @ModelAttribute("todosStatusCadastro")
    public List<StatusCliente> todosStatusClientes() {
        return Arrays.asList(StatusCliente.values());
    }
}
