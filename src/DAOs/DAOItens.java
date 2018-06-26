package DAOs;

import Entidades.Itens;
import Entidades.ItensPK;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DAOItens extends DAOGenerico<Itens> {

    private List<Itens> lista = new ArrayList<>();

    public DAOItens() {
        super(Itens.class);
    }

    public Itens obter(ItensPK precoUnitarioPK) {
        return em.find(Itens.class, precoUnitarioPK);
    }

    public List<Itens> listByNome(String nome) {
        return em.createQuery("SELECT e FROM Itens e WHERE e.produto.nomeProduto LIKE :nome").setParameter("nome", "%" + nome + "%").getResultList();
    }

    public List<Itens> listById(int id) {
        return em.createQuery("SELECT e FROM Itens e WHERE e.itensPK.cadastroProdutoIdProduto = :id").setParameter("id", id).getResultList();
    }

    public List<Itens> listInOrderNome() {
        return em.createQuery("SELECT e FROM Itens e ORDER BY e.produto").getResultList();
    }

    public List<Itens> listInOrderId() {
        return em.createQuery("SELECT e FROM Itens e ORDER BY e.itensPK.cadastroProdutoIdProduto").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        List<Itens> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getItensPK().getCadastroProdutoIdProduto() + "-"
                    + lf.get(i).getProduto().getNomeProduto() + "-"
                    + Integer.valueOf(lf.get(i).getItensPK().getVendaIdVenda())
                    + "-" + lf.get(i).getVenda());
        }
        return ls;
    }

    public static void main(String[] args) {
        DAOItens daoItens = new DAOItens();
        List<Itens> listaItens = daoItens.list();
        for (Itens precoUnitario : listaItens) {
            System.out.println(precoUnitario.getPrecoUnitario() + "-" + precoUnitario.getProduto());
        }
    }
}
