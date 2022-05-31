/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GelDisfarce.PI3.Repository;

import com.GelDisfarce.PI3.Model.CadastroAgendamento;
import com.GelDisfarce.PI3.Model.CadastroAdministrador;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jbarros
 */
public interface AgendamentosHorarios extends JpaRepository<CadastroAgendamento, Long>{
    
}