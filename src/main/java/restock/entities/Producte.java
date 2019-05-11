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
 * The Class Producte.
 */
@Entity
@Table(name = "producte")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Producte implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String marca;
	private String model;
	private String descripcio;
	private Double preu;
	private Double preuVenda;
	private SubFamilia subfamilia;
	private Proveidor proveidor;
	
	/**
	 * Producte.
	 */
	public Producte() {
	}

	/**
	 * Producte.
	 *
	 * @param id the id
	 */
	public Producte(final Integer id) {
		super();
		this.id = id;
	}

	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "marca", nullable = false)
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	@Column(name = "model", nullable = false)
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Column(name = "descripcio", nullable = false)
	public String getDescripcio() {
		return descripcio;
	}

	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}

	@Column(name = "preu", nullable = false)
	public Double getPreu() {
		return preu;
	}

	public void setPreu(Double preu) {
		this.preu = preu;
	}

	@Column(name = "preuVenda", nullable = false)
	public Double getPreuVenda() {
		return preuVenda;
	}

	public void setPreuVenda(Double preuVenda) {
		this.preuVenda = preuVenda;
	}

	
	@Fetch(FetchMode.JOIN)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subfamilia_id", nullable = false)
	public SubFamilia getSubfamilia() {
		return subfamilia;
	}

	public void setSubfamilia (SubFamilia subfamilia) {
		this.subfamilia =subfamilia;
	}
	
	@Fetch(FetchMode.JOIN)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "proveidor_id", nullable = false)
	public Proveidor getProveidor() {
		return proveidor;
	}

	public void setProveidor (Proveidor proveidor) {
		this.proveidor =proveidor;
	}
	
}
