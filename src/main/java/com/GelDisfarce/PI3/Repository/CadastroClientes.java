package com.GelDisfarce.PI3.Repository;

import com.GelDisfarce.PI3.Model.CadastroCliente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jardel
 */
public interface CadastroClientes extends JpaRepository<CadastroCliente, Long>{
    
    public List<CadastroCliente> findByNomeContaining(String nome);
    
}
