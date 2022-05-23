package com.GelDisfarce.PI3.Model;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jardel
 */
@Entity
public class CadastroFuncionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @NotBlank(message = "Campo nome não pode está vazio")
    @NotNull
    @Size(max = 30, message = "Gentileza abreviar o nome")
    private String nome;

    @NotBlank(message = "Campo CPF não pode está vazio")
    @NotNull
    @Size(max = 11, message = "Preencha corretamente o CPF com 11 caracteres")
    private String CPF;

    @NotBlank(message = "Campo Telefone Vazio")
    @NotNull
    @Size(max = 20)
    private String telefone;

    @NotBlank(message = "Campo função não pode está vazio")
    @NotNull
    private String funcao;

    @NotBlank(message = "Campo cep não pode está vazio")
    @NotNull
    private String cep;

    @NotBlank(message = "Campo rua não pode está vazio")
    @NotNull
    private String rua;

    @NotBlank(message = "Campo bairro não pode está vazio")
    @NotNull
    private String bairro;

    @NotBlank(message = "Campo cidade não pode está vazio")
    @NotNull
    private String cidade;

    @NotBlank(message = "Campo estado não pode está vazio")
    @NotNull
    private String estado;

    @NotBlank(message = "Campo complemento não pode está vazio")
    @NotNull
    private String complemento;

    @NotBlank(message = "Campo número não pode está vazio")
    @NotNull
    private String numero;

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

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.codigo);
        hash = 73 * hash + Objects.hashCode(this.nome);
        hash = 73 * hash + Objects.hashCode(this.CPF);
        hash = 73 * hash + Objects.hashCode(this.telefone);
        hash = 73 * hash + Objects.hashCode(this.funcao);
        hash = 73 * hash + Objects.hashCode(this.cep);
        hash = 73 * hash + Objects.hashCode(this.rua);
        hash = 73 * hash + Objects.hashCode(this.bairro);
        hash = 73 * hash + Objects.hashCode(this.cidade);
        hash = 73 * hash + Objects.hashCode(this.estado);
        hash = 73 * hash + Objects.hashCode(this.complemento);
        hash = 73 * hash + Objects.hashCode(this.numero);
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
        final CadastroFuncionario other = (CadastroFuncionario) obj;
        return true;
    }

}
