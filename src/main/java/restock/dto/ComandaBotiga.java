package restock.dto;

import java.util.List;

import restock.entities.Botiga;
import restock.entities.DetallComanda;

public class ComandaBotiga implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private List<DetallComanda> detallComandaList;
	private Botiga botiga;
	
	public ComandaBotiga() {
		super();
	
	}
	
	public ComandaBotiga(List<DetallComanda> detallComandaList, Botiga botiga) {
		super();
		this.detallComandaList = detallComandaList;
		this.botiga = botiga;
	}
	
	public List<DetallComanda> getDetallComandaList() {
		return detallComandaList;
	}
	
	public void setDetallComandaList(List<DetallComanda> detallComandaList) {
		this.detallComandaList = detallComandaList;
	}
	
	public Botiga getBotiga() {
		return botiga;
	}
	
	public void setBotiga(Botiga botiga) {
		this.botiga = botiga;
	}
	
	

}
