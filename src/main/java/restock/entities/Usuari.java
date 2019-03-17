package restock.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

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
@Table(name = "usuari")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Usuari implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String user;
	private String password;
	private String nom;
	private String cognom1;
	private String cognom2;
	private String nif;
	private Date dataNaixement;
	private Rol rol;
	private String correu;
	
	
	public Usuari() {
	}

	public Usuari(final Integer id) {
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

	@Column(name = "user", nullable = false)
	public String getUser() {
		return user;
	}

	public void setUser(final String user) {
		this.user = user;
	}
	
	@Column(name = "password", nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}
	
	@Column(name = "nom", nullable = true)
	public String getNom() {
		return nom;
	}

	public void setNom(final String nom) {
		this.nom = nom;
	}

	@Column(name = "cognom1", nullable = true)
	public String getCognom1() {
		return cognom1;
	}

	public void setCognom1(final String cognom1) {
		this.cognom1 = cognom1;
	}

	@Column(name = "cognom2", nullable = true)
	public String getCognom2() {
		return cognom2;
	}

	public void setCognom2(final String cognom2) {
		this.cognom2 = cognom2;
	}

	@Column(name = "datanaixement", nullable = true)
	public Date getDataNaixement() {
		return dataNaixement;
	}

	public void setDataNaixement(final Date dataNaixement) {
		this.dataNaixement = dataNaixement;
	}
	@Column(name = "nif", nullable = false)
	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	@Fetch(FetchMode.JOIN)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rol_id", nullable = false)
	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	@Column(name = "correu", nullable = false)
	public String getCorreu() {
		return correu;
	}

	public void setCorreu(String correu) {
		this.correu = correu;
	}
	
	

}
