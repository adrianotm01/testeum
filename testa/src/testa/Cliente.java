package testa;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Cliente implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 110210338554081514L;

	@Column(name="cod_cliente")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="nome")
	private String proprietario;
	private String propriedade;
	private String telefone;
	private String tipo;
	@OneToOne(mappedBy = "cliente")
	private Endereco endereco;
	
	public String getPropriedade() {
		return propriedade;
	}

	public void setPropriedade(String propriedade) {
		this.propriedade = propriedade;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}



	public String getProprietario() {
		return proprietario;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getId() {
		return id;
	}
	
}
