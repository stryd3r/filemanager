package com.filemanager.utils.transporters;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the raspuns_chestionar database table.
 * 
 */
@Embeddable
public class RaspunsChestionarPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_pacient", insertable=false, updatable=false)
	private int idPacient;

	@Column(name="id_chestionar", insertable=false, updatable=false)
	private int idChestionar;

	@Column(name="id_intrebare", insertable=false, updatable=false)
	private int idIntrebare;

	public RaspunsChestionarPK() {
	}
	public int getIdPacient() {
		return this.idPacient;
	}
	public void setIdPacient(int idPacient) {
		this.idPacient = idPacient;
	}
	public int getIdChestionar() {
		return this.idChestionar;
	}
	public void setIdChestionar(int idChestionar) {
		this.idChestionar = idChestionar;
	}
	public int getIdIntrebare() {
		return this.idIntrebare;
	}
	public void setIdIntrebare(int idIntrebare) {
		this.idIntrebare = idIntrebare;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RaspunsChestionarPK)) {
			return false;
		}
		RaspunsChestionarPK castOther = (RaspunsChestionarPK)other;
		return 
			(this.idPacient == castOther.idPacient)
			&& (this.idChestionar == castOther.idChestionar)
			&& (this.idIntrebare == castOther.idIntrebare);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idPacient;
		hash = hash * prime + this.idChestionar;
		hash = hash * prime + this.idIntrebare;
		
		return hash;
	}
}