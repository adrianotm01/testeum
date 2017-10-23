package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import interfaces.GenericDAO;
import util.HibernateUtil;

public class GenericDAOImpl<E, ID extends Serializable> implements GenericDAO<E,ID>{
	private Session sessao;
	Transaction trans;
	private Class<E> classepersistida;
	public GenericDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	public GenericDAOImpl(Class<E> classepersistida) {
		// TODO Auto-generated constructor stub
		this.classepersistida = classepersistida;
	}
	
	@Override
	public void salvar(E objeto) {
		try{
			sessao = HibernateUtil.getSessionFactory().openSession();
			Transaction trans = sessao.beginTransaction();
			sessao.save(objeto);
			trans.commit();
			
			}
			finally{
				sessao.close();
			}
		
	}

	@Override
	public List<E> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editar(E objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(E objeto) {
		// TODO Auto-generated method stub
		
	}

}
