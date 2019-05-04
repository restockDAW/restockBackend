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
 * The Class Botiga.
 */
@Entity
@Table(name = "botiga")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Botiga implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Organitzacio organitzacio;
	private Usuari usuari;
	private String nom;
	private String carrer;
	private String numero;
	private String codiPostal;
	private String poblacio;
	private String pais;
	
	
	/**
	 * Botiga.
	 */
	public Botiga() {
	}

	/**
	 * Botiga.
	 *
	 * @param id
	 */
	public Botiga(final Integer id) {
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

	@Column(name = "nom", nullable = false)
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Fetch(FetchMode.JOIN)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "organitzacio_id", nullable = false)
	public Organitzacio getOrganitzacio() {
		return organitzacio;
	}

	public void setOrganitzacio(Organitzacio organitzacio) {
		this.organitzacio = organitzacio;
	}
	
	@Fetch(FetchMode.JOIN)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuari_id", nullable = false)
	public Usuari getUsuari() {
		return usuari;
	}

	public void setUsuari (Usuari usuari) {
		this.usuari = usuari;
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

}
