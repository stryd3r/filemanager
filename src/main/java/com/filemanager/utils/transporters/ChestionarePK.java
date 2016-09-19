package com.filemanager.utils.transporters;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the chestionare database table.
 * 
 */
@Embeddable
public class ChestionarePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int id;

	@Column(name="id_intrebare")
	private int idIntrebare;

	public ChestionarePK() {
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
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
		if (!(other instanceof ChestionarePK)) {
			return false;
		}
		ChestionarePK castOther = (ChestionarePK)other;
		return 
			(this.id == castOther.id)
			&& (this.idIntrebare == castOther.idIntrebare);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id;
		hash = hash * prime + this.idIntrebare;
		
		return hash;
	}
}