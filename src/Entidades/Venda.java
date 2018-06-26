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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Bruna
 */
@Entity
@Table(name = "venda")
@NamedQueries({
    @NamedQuery(name = "Venda.findAll", query = "SELECT v FROM Venda v")})
public class Venda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_venda")
    private Integer idVenda;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venda")
    private List<Itens> itensList;
    @JoinColumn(name = "cadastro_cliente_CPF", referencedColumnName = "CPF")
    @ManyToOne(optional = false)
    private Cliente cadastroclienteCPF;

    public Venda() {
    }

    public Venda(Integer idVenda) {
        this.idVenda = idVenda;
    }

    public Integer getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(Integer idVenda) {
        this.idVenda = idVenda;
    }

    public List<Itens> getItensList() {
        return itensList;
    }

    public void setItensList(List<Itens> itensList) {
        this.itensList = itensList;
    }

    public Cliente getCadastroclienteCPF() {
        return cadastroclienteCPF;
    }

    public void setCadastroclienteCPF(Cliente cadastroclienteCPF) {
        this.cadastroclienteCPF = cadastroclienteCPF;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVenda != null ? idVenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venda)) {
            return false;
        }
        Venda other = (Venda) object;
        if ((this.idVenda == null && other.idVenda != null) || (this.idVenda != null && !this.idVenda.equals(other.idVenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  idVenda + "-" + cadastroclienteCPF;
    }
    
}
