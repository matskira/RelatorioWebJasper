package br.com.foursys.relatorio.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.foursys.relatorio.bean.Cliente;
import br.com.foursys.relatorio.util.HibernateUtil;

public class ClienteDAO extends GenericDAO {

    @SuppressWarnings("unchecked")
    public ArrayList<Cliente> buscarTodos() throws Exception {

        ArrayList<Cliente> listaRetorno = new ArrayList<Cliente>();
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = sessao.createCriteria(Cliente.class);
        criteria.addOrder(Order.asc("codigo"));
        listaRetorno = (ArrayList<Cliente>) criteria.list();

        return listaRetorno;
    }

    public ArrayList<Cliente> buscarNome(String nome) throws Exception {

        ArrayList<Cliente> listaRetorno = new ArrayList<Cliente>();
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = sessao.createCriteria(Cliente.class);
        criteria.add(Restrictions.ilike("nome", nome + "%"));
        criteria.addOrder(Order.asc("nome"));
        listaRetorno = (ArrayList<Cliente>) criteria.list();

        return listaRetorno;
    }

    public Cliente buscarPorCodigo(int codigo) throws Exception {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Cliente cliente = (Cliente) sessao.get(Cliente.class, codigo);
        return cliente;
    }

}