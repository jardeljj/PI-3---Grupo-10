
package com.GelDisfarce.PI3.Model;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


/**
 *
 * @author jardel
 */
@Entity
public class CadastroCliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    
    @NotBlank(message = "Campo nome não pode está vazio")
    
    @Size(max = 30, message = "Gentileza abreviar o nome")
    private String nome;
    
    @NotBlank(message = "Campo CPF não pode está vazio")
    @NotNull
    @Size(max = 11, message = "Preencha corretamente o CPF com 11 caracteres")
    private String CPF;
    
    @NotBlank(message = "Campo Telefone está incorreto")
    @NotNull
    @Size(max = 20)
    String telefone;
    
    @Enumerated(EnumType.STRING)
    private StatusCliente status;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public StatusCliente getStatus() {
        return status;
    }

    public void setStatus(StatusCliente status) {
        this.status = status;
    }
    
    public boolean isInativo(){
        return StatusCliente.INATIVO.equals(this.status);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CadastroCliente other = (CadastroCliente) obj;
        return Objects.equals(this.codigo, other.codigo);
    }
    
    
}
