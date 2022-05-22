/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.GelDisfarce.PI3.Repository;

import com.GelDisfarce.PI3.Model.CadastroAdministrador;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jarde
 */
public interface CadastroAdministradores extends JpaRepository<CadastroAdministrador, Long> {
    
}
