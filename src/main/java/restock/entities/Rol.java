package restock.entities;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "rol")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Rol implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String tipus;
	private String descripcio;
	
	
	public Rol() {
	}

	public Rol(final Integer id) {
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
	
	@Column(name = "tipus", nullable = false)
	public String getTipus() {
		return tipus;
	}

	public void setTipus(final String tipus) {
		this.tipus = tipus;
	}

	@Column(name = "descripcio", nullable = false)
	public String getDescripcio() {
		return descripcio;
	}

	public void setDescripcio(final String descripcio) {
		this.descripcio = descripcio;
	}	

}
