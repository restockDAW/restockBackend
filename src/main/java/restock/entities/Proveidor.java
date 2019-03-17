package restock.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "proveidor")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Proveidor extends Organitzacio implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer plasEntrega;
	
	
	public Proveidor() {
	}

	public Proveidor(final Integer id) {
		super();
	}


	@Column(name = "plasentrega", nullable = false)
	public Integer getPlasEntrega() {
		return plasEntrega;
	}

	public void setPlasEntrega(Integer plasEntrega) {
		this.plasEntrega = plasEntrega;
	}

}
