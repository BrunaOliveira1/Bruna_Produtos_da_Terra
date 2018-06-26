/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Bruna
 */
@Embeddable
public class ItensPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "cadastro_produto_id_produto")
    private int cadastroProdutoIdProduto;
    @Basic(optional = false)
    @Column(name = "venda_id_venda")
    private int vendaIdVenda;

    public ItensPK() {
    }

    public ItensPK(int cadastroProdutoIdProduto, int vendaIdVenda) {
        this.cadastroProdutoIdProduto = cadastroProdutoIdProduto;
        this.vendaIdVenda = vendaIdVenda;
    }

    public int getCadastroProdutoIdProduto() {
        return cadastroProdutoIdProduto;
    }

    public void setCadastroProdutoIdProduto(int cadastroProdutoIdProduto) {
        this.cadastroProdutoIdProduto = cadastroProdutoIdProduto;
    }

    public int getVendaIdVenda() {
        return vendaIdVenda;
    }

    public void setVendaIdVenda(int vendaIdVenda) {
        this.vendaIdVenda = vendaIdVenda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) cadastroProdutoIdProduto;
        hash += (int) vendaIdVenda;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItensPK)) {
            return false;
        }
        ItensPK other = (ItensPK) object;
        if (this.cadastroProdutoIdProduto != other.cadastroProdutoIdProduto) {
            return false;
        }
        if (this.vendaIdVenda != other.vendaIdVenda) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  cadastroProdutoIdProduto + "-" + vendaIdVenda + "-";
    }
    
}
