/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.GelDisfarce.PI3.Controller;

import com.GelDisfarce.PI3.Model.CadastroAdministrador;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author jarde
 */
@Controller
public class homeController {
    
    @RequestMapping("/home")
    public ModelAndView novo() {
        ModelAndView mv = new ModelAndView("home");
        return mv;
    }
    
}
