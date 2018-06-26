/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Bruna
 */
@Entity
@Table(name = "produto")
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p")})
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_produto")
    private Integer idProduto;
    @Basic(optional = false)
    @Column(name = "nome_produto")
    private String nomeProduto;
    @Basic(optional = false)
    @Column(name = "data_validade")
    @Temporal(TemporalType.DATE)
    private Date dataValidade;
    @Basic(optional = false)
    @Column(name = "data_fabricacao")
    @Temporal(TemporalType.DATE)
    private Date dataFabricacao;
    @Column(name = "beneficio_saude")
    private String beneficioSaude;
    @Basic(optional = false)
    @Column(name = "preco")
    private double preco;
    @Basic(optional = false)
    @Column(name = "caminho")
    private String caminho;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produto")
    private List<Itens> itensList;
    @JoinColumn(name = "cadastro_marca_id_marca", referencedColumnName = "id_marca")
    @ManyToOne(optional = false)
    private Marca cadastroMarcaIdMarca;
    @JoinColumn(name = "cadastro_tipo_id_tipo", referencedColumnName = "id_tipo")
    @ManyToOne(optional = false)
    private Tipo cadastroTipoIdTipo;
    @JoinColumn(name = "unidade_medida_id_unidade_medida", referencedColumnName = "id_unidade_medida")
    @ManyToOne(optional = false)
    private UnidadeMedida unidadeMedidaIdUnidadeMedida;

    public Produto() {
    }

    public Produto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public Produto(Integer idProduto, String nomeProduto, Date dataValidade, Date dataFabricacao, double preco, String caminho) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.dataValidade = dataValidade;
        this.dataFabricacao = dataFabricacao;
        this.preco = preco;
        this.caminho = caminho;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    public Date getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(Date dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public String getBeneficioSaude() {
        return beneficioSaude;
    }

    public void setBeneficioSaude(String beneficioSaude) {
        this.beneficioSaude = beneficioSaude;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public List<Itens> getItensList() {
        return itensList;
    }

    public void setItensList(List<Itens> itensList) {
        this.itensList = itensList;
    }

    public Marca getCadastroMarcaIdMarca() {
        return cadastroMarcaIdMarca;
    }

    public void setCadastroMarcaIdMarca(Marca cadastroMarcaIdMarca) {
        this.cadastroMarcaIdMarca = cadastroMarcaIdMarca;
    }

    public Tipo getCadastroTipoIdTipo() {
        return cadastroTipoIdTipo;
    }

    public void setCadastroTipoIdTipo(Tipo cadastroTipoIdTipo) {
        this.cadastroTipoIdTipo = cadastroTipoIdTipo;
    }

    public UnidadeMedida getUnidadeMedidaIdUnidadeMedida() {
        return unidadeMedidaIdUnidadeMedida;
    }

    public void setUnidadeMedidaIdUnidadeMedida(UnidadeMedida unidadeMedidaIdUnidadeMedida) {
        this.unidadeMedidaIdUnidadeMedida = unidadeMedidaIdUnidadeMedida;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduto != null ? idProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.idProduto == null && other.idProduto != null) || (this.idProduto != null && !this.idProduto.equals(other.idProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  idProduto + "";
    }
    
}
