package com.filemanager.utils.transporters;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the raspuns_chestionar database table.
 * 
 */
@Entity
@Table(name="raspuns_chestionar")
@NamedQuery(name="RaspunsChestionar.findAll", query="SELECT r FROM RaspunsChestionar r")
public class RaspunsChestionar implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RaspunsChestionarPK id;

	private String raspuns;

	//bi-directional many-to-one association to Chestionare
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="id_chestionar", referencedColumnName="id"),
		@JoinColumn(name="id_intrebare", referencedColumnName="id_intrebare")
		})
	private Chestionare chestionare;

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_pacient")
	private Pacienti pacienti;

	public RaspunsChestionar() {
	}

	public RaspunsChestionarPK getId() {
		return this.id;
	}

	public void setId(RaspunsChestionarPK id) {
		this.id = id;
	}

	public String getRaspuns() {
		return this.raspuns;
	}

	public void setRaspuns(String raspuns) {
		this.raspuns = raspuns;
	}

	public Chestionare getChestionare() {
		return this.chestionare;
	}

	public void setChestionare(Chestionare chestionare) {
		this.chestionare = chestionare;
	}

	public Pacienti getPacienti() {
		return this.pacienti;
	}

	public void setPacienti(Pacienti pacienti) {
		this.pacienti = pacienti;
	}

}