package DAOs;

import Entidades.UnidadeMedida;
import DAOs.DAOGenerico;
import static DAOs.DAOGenerico.em;
import java.util.ArrayList;
import java.util.List;

public class DAOUnidadeMedida extends DAOGenerico<UnidadeMedida> {

    public DAOUnidadeMedida() {
        super(UnidadeMedida.class);
    }

    public int autoIdUnidadeMedida() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idUnidadeMedida) FROM UnidadeMedida e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<UnidadeMedida> listByNome(String nome) {
        return em.createQuery("SELECT e FROM UnidadeMedida e WHERE e.nomeUnidadeMedida LIKE :nome").setParameter("nome", "%" + nome + "%").getResultList();
    }

    public List<UnidadeMedida> listById(int id) {
        return em.createQuery("SELECT e FROM UnidadeMedida e WHERE e.idUnidadeMedida = :id").setParameter("id", id).getResultList();
    }

    public List<UnidadeMedida> listInOrderNome() {
        return em.createQuery("SELECT e FROM UnidadeMedida e ORDER BY e.nomeUnidadeMedida").getResultList();
    }

    public List<UnidadeMedida> listInOrderId() {
        return em.createQuery("SELECT e FROM UnidadeMedida e ORDER BY e.idUnidadeMedida").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<UnidadeMedida> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdUnidadeMedida() + "-" + lf.get(i).getNomeUnidadeMedida());
        }
        return ls;
    }

    public static void main(String[] args) {
        DAOUnidadeMedida daoUnidadeMedida = new DAOUnidadeMedida();
        List<UnidadeMedida> listaUnidadeMedida = daoUnidadeMedida.list();
        for (UnidadeMedida unidadeMedida : listaUnidadeMedida) {
            System.out.println(unidadeMedida.getIdUnidadeMedida() + "-" + unidadeMedida.getNomeUnidadeMedida());
        }
    }
}
