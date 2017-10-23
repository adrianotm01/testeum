package dao;

import interfaces.EnderecoDAO;
import testa.Endereco;

public class EnderecoDAOImpl extends GenericDAOImpl<Endereco,Integer> implements EnderecoDAO{
	public EnderecoDAOImpl(){
		super(Endereco.class);
	}
}
