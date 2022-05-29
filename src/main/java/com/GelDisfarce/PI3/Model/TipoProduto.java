
package com.GelDisfarce.PI3.Model;

/**
 *
 * @author jardel
 */
public enum TipoProduto {
    
    SERVIÇO("Serviço"),
    PRODUTO("Produto");
    
    private String nome;
    
    TipoProduto(String descricao){
        this.nome = descricao;
    }
    
    public String getDescricao(){
        return nome; 
    }
    
}
