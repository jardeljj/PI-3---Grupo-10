package com.GelDisfarce.PI3.Controller;

import com.GelDisfarce.PI3.Model.CadastroCliente;
import com.GelDisfarce.PI3.Model.StatusCliente;
import com.GelDisfarce.PI3.Repository.CadastroClientes;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author jardel
 */
@Controller
@RequestMapping("/cadastro")
public class ClienteController {

    @Autowired
    private CadastroClientes CadastroClientes;

    @RequestMapping("/cliente")
    public ModelAndView novo() {
        ModelAndView mv = new ModelAndView("CadastroCliente");
        mv.addObject("todosStatusCadastro", StatusCliente.values());
        mv.addObject(new CadastroCliente());
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView salvar(@Validated CadastroCliente cadastroCliente, Errors errors) {
        ModelAndView mv = new ModelAndView("CadastroCliente");
        if (errors.hasErrors()) {
            return mv;
        }
        CadastroClientes.save(cadastroCliente);

        mv.addObject("mensagem", "Cliente Cadastrado com Sucesso!!!");
        return mv;
    }

    @RequestMapping
    public ModelAndView ListarCliente() {
        List<CadastroCliente> todosClientes = CadastroClientes.findAll();
        ModelAndView mv = new ModelAndView("ListaCliente");
        mv.addObject("clientes", todosClientes);
        return mv;
    }

    @ModelAttribute("todosStatusCadastro")
    public List<StatusCliente> todosStatusClientes() {
        return Arrays.asList(StatusCliente.values());
    }
}
