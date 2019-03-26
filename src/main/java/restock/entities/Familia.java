package restock.entities;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "familia")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Familia implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nomFamilia;
	private String descripcio;
	
	
	public Familia() {
	}

	public Familia(final Integer id) {
		super();
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}
	
	@Column(name = "nomFamilia", nullable = false)
	public String getNomFamilia() {
		return nomFamilia;
	}

	public void setNomFamilia(final String nomFamilia) {
		this.nomFamilia = nomFamilia;
	}

	@Column(name = "descripcio", nullable = true)
	public String getDescripcio() {
		return descripcio;
	}

	public void setDescripcio(final String descripcio) {
		this.descripcio = descripcio;
	}	

}
