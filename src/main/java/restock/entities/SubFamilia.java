/*
 * 
 * Albert Codina
 */
package restock.entities;

import static javax.persistence.GenerationType.IDENTITY;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * The Class SubFamilia.
 */
@Entity
@Table(name = "subfamilia")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class SubFamilia implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nomSubfamilia;
	private String descripcio;
	private Familia familia;
	
	
	/**
	 * Sub familia.
	 */
	public SubFamilia() {
	}

	/**
	 * Sub familia.
	 *
	 * @param id 
	 */
	public SubFamilia(final Integer id) {
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
	
	@Column(name = "nomSubfamilia", nullable = false)
	public String getNomSubfamilia() {
		return nomSubfamilia;
	}

	public void setNomSubfamilia(final String nomSubfamilia) {
		this.nomSubfamilia = nomSubfamilia;
	}

	@Column(name = "descripcio", nullable = true)
	public String getDescripcio() {
		return descripcio;
	}

	public void setDescripcio(final String descripcio) {
		this.descripcio = descripcio;
	}	
	
	@Fetch(FetchMode.JOIN)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "familia_id", nullable = false)
	public Familia getFamilia() {
		return familia;
	}

	public void setFamilia(Familia familia) {
		this.familia = familia;
	}

}
