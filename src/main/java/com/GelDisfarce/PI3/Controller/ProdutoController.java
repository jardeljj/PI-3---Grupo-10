package com.GelDisfarce.PI3.Controller;

import com.GelDisfarce.PI3.Model.CadastroProduto;
import com.GelDisfarce.PI3.Model.TipoProduto;
import com.GelDisfarce.PI3.Repository.CadastroProdutos;
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
@RequestMapping("/produto")
public class ProdutoController {

    private static final String CADASTRO_VIEW = "CadastroProduto";

    @Autowired
    private CadastroProdutos CadastroProdutos;

    @RequestMapping("/novo")
    public ModelAndView novo() {
        ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
        mv.addObject("todosTipoProduto", TipoProduto.values());
        mv.addObject(new CadastroProduto());
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String salvar(@Validated CadastroProduto cadastroProduto, Errors errors, RedirectAttributes attributes) {
        if (errors.hasErrors()) {
            return CADASTRO_VIEW;
        }
        CadastroProdutos.save(cadastroProduto);

        attributes.addFlashAttribute("mensagem", "Produto Cadastrado com Sucesso!!!");
        return "redirect:/produto/novo";
    }

    @RequestMapping
    public ModelAndView ListarCliente(@RequestParam(defaultValue = "") String nome) {

        List<CadastroProduto> todosProdutos = CadastroProdutos.findAll();

        ModelAndView mv = new ModelAndView("RelatorioProdutos");
        mv.addObject("produtos", todosProdutos);
        return mv;
    }

    @RequestMapping("{codigo}")
    public ModelAndView edicao(@PathVariable("codigo") Long codigoCadastroProduto) {
        CadastroProduto cadastroProduto = CadastroProdutos.getOne(codigoCadastroProduto);

        ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
        mv.addObject(cadastroProduto);
        return mv;
    }

    @RequestMapping(value = "{codigo}", method = RequestMethod.DELETE)
    public String excluir(@PathVariable Long codigo, RedirectAttributes attributes) {
        CadastroProdutos.deleteById(codigo);

        attributes.addFlashAttribute("mensagem", "Título excluído com sucesso!");
        return "redirect:/produto";
    }

    @ModelAttribute("todosTipoProduto")
    public List<TipoProduto> todosTipoProdutos() {
        return Arrays.asList(TipoProduto.values());
    }

}
