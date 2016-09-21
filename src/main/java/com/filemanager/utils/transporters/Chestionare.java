package com.filemanager.utils.transporters;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the chestionare database table.
 * 
 */
@Entity
@NamedQuery(name = "Chestionare.findAll", query = "SELECT c FROM Chestionare c")
public class Chestionare implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ChestionarePK id;

	private String intrebare;

	// bi-directional many-to-one association to RaspunsChestionar
	@OneToMany(mappedBy = "chestionar")
	private List<RaspunsChestionar> raspunsChestionar;

	public Chestionare() {
	}

	public ChestionarePK getId() {
		return this.id;
	}

	public void setId(ChestionarePK id) {
		this.id = id;
	}

	public String getIntrebare() {
		return this.intrebare;
	}

	public void setIntrebare(String intrebare) {
		this.intrebare = intrebare;
	}

	public List<RaspunsChestionar> getRaspunsChestionar() {
		return raspunsChestionar;
	}

	public void setRaspunsChestionar(List<RaspunsChestionar> raspunsChestionar) {
		this.raspunsChestionar = raspunsChestionar;
	}

	public RaspunsChestionar addRaspunsChestionar(RaspunsChestionar raspunsChestionar) {
		getRaspunsChestionar().add(raspunsChestionar);
		raspunsChestionar.setChestionar(this);

		return raspunsChestionar;
	}

	public RaspunsChestionar removeRaspunsChestionar(RaspunsChestionar raspunsChestionar) {
		getRaspunsChestionar().remove(raspunsChestionar);
		raspunsChestionar.setChestionar(null);

		return raspunsChestionar;
	}

}