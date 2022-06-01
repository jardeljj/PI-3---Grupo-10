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
@RequestMapping("/agendamento")
public class AgendamentoController {

    private static final String CADASTRO_VIEW = "Agendamento";

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
            return CADASTRO_VIEW;
        }
        AgendamentosHorarios.save(cadastroAgendamento);

        attributes.addFlashAttribute("mensagem", "Data e Hora Marcados com Sucesso!!!");
        return "redirect:/agendamento/novo";
    }

    @RequestMapping
    public ModelAndView ListaAgenda(@RequestParam(defaultValue = "") String nome) {

        List<CadastroAgendamento> todosAgendamentos = AgendamentosHorarios.findAll();

        ModelAndView mv = new ModelAndView("ListaAgendamento");
        mv.addObject("agendamentos", todosAgendamentos);
        return mv;
    }

    @RequestMapping("{codigo}")
    public ModelAndView edicao(@PathVariable("codigo") Long codigoCadastroAgendamento) {
        CadastroAgendamento cadastroAgendamento = AgendamentosHorarios.getOne(codigoCadastroAgendamento);

        ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
        mv.addObject(cadastroAgendamento);
        return mv;
    }

    @RequestMapping(value = "{codigo}", method = RequestMethod.DELETE)
    public String excluir(@PathVariable Long codigo, RedirectAttributes attributes) {
        AgendamentosHorarios.deleteById(codigo);

        attributes.addFlashAttribute("mensagem", "Data e hora excluídos com sucesso!");
        return "redirect:/agendamento";
    }
    
}
