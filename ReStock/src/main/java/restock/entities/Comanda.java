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
@Table(name = "comanda")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Comanda implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Date dataComanda;
	private Botiga botiga;
	private Proveidor proveidor;
	private Date dataRecepcio;
	
	public Comanda() {
	}

	public Comanda(final Integer id) {
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

	@Column(name = "dataComanda", nullable = false)
	public Date getDataComanda() {
		return dataComanda;
	}

	public void setDataComanda(Date dataComanda) {
		this.dataComanda = dataComanda;
	}

	@Fetch(FetchMode.JOIN)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "botiga_id", nullable = false)
	public Botiga getBotiga() {
		return botiga;
	}

	public void setBotiga (Botiga botiga) {
		this.botiga = botiga;
	}
	
	@Fetch(FetchMode.JOIN)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "proveidor_id", nullable = false)
	public Proveidor getProveidor() {
		return proveidor;
	}

	public void setProveidor(Proveidor proveidor) {
		this.proveidor = proveidor;
	}
	
	@Column(name = "dataRecepcio", nullable = true)
	public Date getDataRecepcio() {
		return dataRecepcio;
	}

	public void setDataRecepcio(Date dataRecepcio) {
		this.dataRecepcio = dataRecepcio;
	}
	

}
