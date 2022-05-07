package com.GelDisfarce.PI3.Model;

/**
 *
 * @author jardel
 */
public enum StatusCliente {
    
    ATIVO("Ativo"),
    INATIVO("Inativo");
    
    private String nome;
    
    StatusCliente(String descricao){
        this.nome = descricao;
    }
    
    public String getDescricao(){
        return nome; 
    }
}
