/*
 * 
 * Albert Codina
 */
package restock.entities;

import static javax.persistence.GenerationType.IDENTITY;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * The Class Menu.
 */
@Entity
@Table(name = "menu")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Menu implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String descripcio;
	
	
	/**
	 * Menu.
	 */
	public Menu() {
	}

	/**
	 * Menu.
	 *
	 * @param id the id
	 */
	public Menu(final Integer id) {
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
	

	@Column(name = "descripcio", nullable = false)
	public String getDescripcio() {
		return descripcio;
	}

	public void setDescripcio(final String descripcio) {
		this.descripcio = descripcio;
	}	

}
