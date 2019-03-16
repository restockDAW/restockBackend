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


@Entity
@Table(name = "organitzacio")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Organitzacio implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nif;
	private String nom;
	private Usuari usuari;
	private String carrer;
	private String numero;
	private String codiPostal;
	private String poblacio;
	private String pais;
	
	
	public Organitzacio() {
	}

	public Organitzacio(final Integer id) {
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

	@Fetch(FetchMode.JOIN)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuari_id", nullable = false)
	public Usuari getUsuari() {
		return usuari;
	}

	public void setUsuari (Usuari usuari) {
		this.usuari = usuari;
	}
	
	@Column(name = "carrer", nullable = false)
	public String getCarrer() {
		return carrer;
	}

	public void setCarrer(String carrer) {
		this.carrer = carrer;
	}

	@Column(name = "numero", nullable = false)
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Column(name = "codiPostal", nullable = false)
	public String getCodiPostal() {
		return codiPostal;
	}

	public void setCodiPostal(String codiPostal) {
		this.codiPostal = codiPostal;
	}

	@Column(name = "poblacio", nullable = false)
	public String getPoblacio() {
		return poblacio;
	}

	public void setPoblacio(String poblacio) {
		this.poblacio = poblacio;
	}

	@Column(name = "pais", nullable = false)
	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

}
