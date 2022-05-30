package com.GelDisfarce.PI3.Model;

/**
 *
 * @author jardel
 */
public enum TipoFuncao {
    
    CAIXA("Caixa"),
    MANICURE("Manicure");
    
    private String nome;
    
    TipoFuncao(String descricao){
        this.nome = descricao;
    }
    
    public String getDescricao(){
        return nome; 
    }
}
