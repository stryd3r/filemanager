package com.filemanager.utils.transporters;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the consultatii database table.
 * 
 */
@Embeddable
public class ConsultatiiPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int id;

	@Column(name="id_pacient", insertable=false, updatable=false)
	private int idPacient;

	@Column(name="id_doctor", insertable=false, updatable=false)
	private int idDoctor;

	public ConsultatiiPK() {
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdPacient() {
		return this.idPacient;
	}
	public void setIdPacient(int idPacient) {
		this.idPacient = idPacient;
	}
	public int getIdDoctor() {
		return this.idDoctor;
	}
	public void setIdDoctor(int idDoctor) {
		this.idDoctor = idDoctor;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ConsultatiiPK)) {
			return false;
		}
		ConsultatiiPK castOther = (ConsultatiiPK)other;
		return 
			(this.id == castOther.id)
			&& (this.idPacient == castOther.idPacient)
			&& (this.idDoctor == castOther.idDoctor);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id;
		hash = hash * prime + this.idPacient;
		hash = hash * prime + this.idDoctor;
		
		return hash;
	}
}