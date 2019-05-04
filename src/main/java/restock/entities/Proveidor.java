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
 * The Class Proveidor.
 */
@Entity
@Table(name = "proveidor")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Proveidor implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nif;
	private String nom;
	private String carrer;
	private String numero;
	private String codiPostal;
	private String poblacio;
	private String pais;
	private Integer plasEntrega;
	private Organitzacio organitzacio;
	
	
	/**
	 * Proveidor.
	 */
	public Proveidor() {
	}

	/**
	 * Proveidor.
	 *
	 * @param id
	 */
	public Proveidor(final Integer id) {
		super();
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


	@Column(name = "nif", nullable = false)
	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	@Column(name = "nom", nullable = false)
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "carrer", nullable = true)
	public String getCarrer() {
		return carrer;
	}

	public void setCarrer(String carrer) {
		this.carrer = carrer;
	}

	@Column(name = "numero", nullable = true)
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Column(name = "codiPostal", nullable = true)
	public String getCodiPostal() {
		return codiPostal;
	}

	public void setCodiPostal(String codiPostal) {
		this.codiPostal = codiPostal;
	}

	@Column(name = "poblacio", nullable = true)
	public String getPoblacio() {
		return poblacio;
	}

	public void setPoblacio(String poblacio) {
		this.poblacio = poblacio;
	}

	@Column(name = "pais", nullable = true)
	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}


	@Column(name = "plas_entrega", nullable = false)
	public Integer getPlasEntrega() {
		return plasEntrega;
	}

	public void setPlasEntrega(Integer plasEntrega) {
		this.plasEntrega = plasEntrega;
	}
	
	@Fetch(FetchMode.JOIN)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "organitzacio_id")
	public Organitzacio getOrganitzacio() {
		return organitzacio;
	}

	public void setOrganitzacio(Organitzacio organitzacio) {
		this.organitzacio = organitzacio;
	}

	
}
