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
 * The Class DetallComanda.
 */
@Entity
@Table(name = "detallcomanda")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class DetallComanda implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Comanda comanda;
	private Producte producte;
	private Double quantitat;
	
	/**
	 * Detall comanda.
	 */
	public DetallComanda() {
	}

	/**
	 * Detall comanda.
	 *
	 * @param id
	 */
	public DetallComanda(final Integer id) {
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


	@Fetch(FetchMode.JOIN)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "comanda_id", nullable = false)
	public Comanda getComanda() {
		return comanda;
	}

	public void setComanda (Comanda comanda) {
		this.comanda = comanda;
	}
	
	@Fetch(FetchMode.JOIN)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "producte_id", nullable = false)
	public Producte getProducte() {
		return producte;
	}

	public void setProducte(Producte producte) {
		this.producte = producte;
	}
	
	@Column(name = "quantitat", nullable = false)
	public Double getQuantitat() {
		return quantitat;
	}

	public void setQuantitat(Double quantitat) {
		this.quantitat = quantitat;
	}
	

}
