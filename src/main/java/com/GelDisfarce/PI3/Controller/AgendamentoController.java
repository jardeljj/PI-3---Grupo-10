package com.GelDisfarce.PI3.Controller;

import com.GelDisfarce.PI3.Model.CadastroAgendamento;
import com.GelDisfarce.PI3.Model.CadastroCliente;
import com.GelDisfarce.PI3.Repository.AgendamentosHorarios;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author jardel
 */
@Controller
@RequestMapping("/agendamento")
public class AgendamentoController {

    @Autowired
    private AgendamentosHorarios AgendamentosHorarios;

    @Autowired
    private CadastroClientes CadastroClientes;

    @RequestMapping("/novo")
    public ModelAndView novo() {
        ModelAndView mv = new ModelAndView("Agendamento");
        mv.addObject(new CadastroAgendamento());
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String salvar(@Validated CadastroAgendamento cadastroAgendamento, Errors errors, RedirectAttributes attributes) {
        if (errors.hasErrors()) {
            return "Agendamento";
        }
        AgendamentosHorarios.save(cadastroAgendamento);

        attributes.addFlashAttribute("mensagem", "Cliente Cadastrado com Sucesso!!!");
        return "redirect:/agendamento/novo";
    }

    @RequestMapping
    public ModelAndView ListarCliente(@RequestParam(defaultValue = "") String nome) {

        List<CadastroCliente> todosClientes = CadastroClientes.findAll();

        ModelAndView mv = new ModelAndView("Agendamento");
        mv.addObject("clientes", todosClientes);
        return mv;

    }

    /*@RequestMapping
    public ModelAndView ListarAgendamento(@RequestParam(defaultValue = "") String nome) {
      
        List<CadastroAgendamento> todosAgendamento = AgendamentosHorarios.findAll();
        
        
        ModelAndView mv = new ModelAndView("ListaAgendamento");
        mv.addObject("agendamentos", todosAgendamento);
        return mv;
        
    }*/
}
