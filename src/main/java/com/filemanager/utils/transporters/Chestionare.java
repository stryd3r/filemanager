package com.filemanager.utils.transporters;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the chestionare database table.
 * 
 */
@Entity
@NamedQuery(name="Chestionare.findAll", query="SELECT c FROM Chestionare c")
public class Chestionare implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ChestionarePK id;

	private String intrebare;

	//bi-directional many-to-one association to RaspunsChestionar
	@OneToMany(mappedBy="chestionare")
	private List<RaspunsChestionar> raspunsChestionars;

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

	public List<RaspunsChestionar> getRaspunsChestionars() {
		return this.raspunsChestionars;
	}

	public void setRaspunsChestionars(List<RaspunsChestionar> raspunsChestionars) {
		this.raspunsChestionars = raspunsChestionars;
	}

	public RaspunsChestionar addRaspunsChestionar(RaspunsChestionar raspunsChestionar) {
		getRaspunsChestionars().add(raspunsChestionar);
		raspunsChestionar.setChestionare(this);

		return raspunsChestionar;
	}

	public RaspunsChestionar removeRaspunsChestionar(RaspunsChestionar raspunsChestionar) {
		getRaspunsChestionars().remove(raspunsChestionar);
		raspunsChestionar.setChestionare(null);

		return raspunsChestionar;
	}

}