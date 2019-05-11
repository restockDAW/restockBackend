/*
 * 
 * Albert Codina
 */
package restock.dto;

/**
 * The Class Cercador.
 */
public class Cercador implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private String camp;
	private Integer orgId;
	
	/**
	 * Cercador.
	 *
	 * @param camp the camp
	 * @param orgId the org id
	 */
	public Cercador(String camp, Integer orgId) {
		super();
		this.camp = camp;
		this.orgId = orgId;
	}
	
	/**
	 * Cercador.
	 */
	public Cercador() {
		super();
	}
	public String getCamp() {
		return camp;
	}
	public void setCamp(String camp) {
		this.camp = camp;
	}
	public Integer getOrgId() {
		return orgId;
	}
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	
	

}
