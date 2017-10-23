package interfaces;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<E,ID extends Serializable> {
	public void salvar(E objeto);
	public List<E> listar();
	public void editar(E objeto);
	public void remover(E objeto);
}
