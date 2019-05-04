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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name = "comanda")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Comanda implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Date datacomanda;
	private Botiga botiga;
	private Proveidor proveidor;
	private Date datarecepcio;
	
	public Comanda() {
	}

	public Comanda(final Integer id) {
		super();
		this.id = id;
	}

	
	public Comanda(Integer id, Date datacomanda, Botiga botiga, Proveidor proveidor, Date datarecepcio) {
		super();
		this.id = id;
		this.datacomanda = datacomanda;
		this.botiga = botiga;
		this.proveidor = proveidor;
		this.datarecepcio = datarecepcio;
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

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "Europe/Madrid")
	@Column(name = "datacomanda", nullable = false)
	public Date getDatacomanda() {
		return datacomanda;
	}

	public void setDatacomanda(Date datacomanda) {
		this.datacomanda = datacomanda;
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

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "Europe/Madrid")
	@Column(name = "datarecepcio", nullable = true)
	public Date getDatarecepcio() {
		return datarecepcio;
	}

	public void setDatarecepcio(Date datarecepcio) {
		this.datarecepcio = datarecepcio;
	}


}
