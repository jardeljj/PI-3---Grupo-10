
package com.GelDisfarce.PI3.Model;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.NumberFormat;

/**
 *
 * @author jardel
 */
@Entity
public class CadastroProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    
    @NotBlank(message = "Campo nome não pode está vazio")
    @NotNull
    @Size(max = 30, message = "Gentileza abreviar o nome do produto")
    private String nome;
    
  
    
    @NotNull
    @NumberFormat(pattern = "#,##0.00")
    private BigDecimal preco;
    
    @NotBlank(message = "Campo quantidade não pode está vazio")
    @NotNull
    private String quantidade;
    
    @Enumerated(EnumType.STRING)
    private TipoProduto tipoProduto;
    
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

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    } 
   
    public TipoProduto getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(TipoProduto tipoProduto) {
        this.tipoProduto = tipoProduto;
    }
    
    public boolean isProduto(){
        return TipoProduto.SERVIÇO.equals(this.tipoProduto);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (this == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        CadastroProduto other = (CadastroProduto) obj;
        if (codigo == null) {
            if (other.codigo != null) {
                return false;
            }
        } else if (!codigo.equals(other.codigo)) {
            return false;
        }
        return true;
    }           
     
}
