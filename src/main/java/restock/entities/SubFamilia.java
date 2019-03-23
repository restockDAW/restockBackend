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
@Table(name = "subfamilia")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class SubFamilia implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nomSubFamilia;
	private String descripcio;
	private Familia familia;
	
	
	public SubFamilia() {
	}

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
	
	@Column(name = "nomSubFamilia", nullable = false)
	public String getNomSubFamilia() {
		return nomSubFamilia;
	}

	public void setNomSubFamilia(final String nomSubFamilia) {
		this.nomSubFamilia = nomSubFamilia;
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
