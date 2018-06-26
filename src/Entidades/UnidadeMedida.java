/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Bruna
 */
@Entity
@Table(name = "unidade_medida")
@NamedQueries({
    @NamedQuery(name = "UnidadeMedida.findAll", query = "SELECT u FROM UnidadeMedida u")})
public class UnidadeMedida implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_unidade_medida")
    private Integer idUnidadeMedida;
    @Basic(optional = false)
    @Column(name = "nome_unidade_medida")
    private String nomeUnidadeMedida;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidadeMedidaIdUnidadeMedida")
    private List<Produto> produtoList;

    public UnidadeMedida() {
    }

    public UnidadeMedida(Integer idUnidadeMedida) {
        this.idUnidadeMedida = idUnidadeMedida;
    }

    public UnidadeMedida(Integer idUnidadeMedida, String nomeUnidadeMedida) {
        this.idUnidadeMedida = idUnidadeMedida;
        this.nomeUnidadeMedida = nomeUnidadeMedida;
    }

    public Integer getIdUnidadeMedida() {
        return idUnidadeMedida;
    }

    public void setIdUnidadeMedida(Integer idUnidadeMedida) {
        this.idUnidadeMedida = idUnidadeMedida;
    }

    public String getNomeUnidadeMedida() {
        return nomeUnidadeMedida;
    }

    public void setNomeUnidadeMedida(String nomeUnidadeMedida) {
        this.nomeUnidadeMedida = nomeUnidadeMedida;
    }

    public List<Produto> getProdutoList() {
        return produtoList;
    }

    public void setProdutoList(List<Produto> produtoList) {
        this.produtoList = produtoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUnidadeMedida != null ? idUnidadeMedida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UnidadeMedida)) {
            return false;
        }
        UnidadeMedida other = (UnidadeMedida) object;
        if ((this.idUnidadeMedida == null && other.idUnidadeMedida != null) || (this.idUnidadeMedida != null && !this.idUnidadeMedida.equals(other.idUnidadeMedida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idUnidadeMedida + "";
    }
    
}
