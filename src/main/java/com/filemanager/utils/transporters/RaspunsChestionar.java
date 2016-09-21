package com.filemanager.utils.transporters;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the raspuns_chestionar database table.
 * 
 */
@Entity
@Table(name = "raspuns_chestionar")
@NamedQuery(name = "RaspunsChestionar.findAll", query = "SELECT r FROM RaspunsChestionar r")
public class RaspunsChestionar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_raspuns_chestionar")
	private int idRaspunsChestionar;

	private String raspuns;

	// bi-directional many-to-one association to Chestionare
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "id_chestionar", referencedColumnName = "id_chestionar"), @JoinColumn(name = "id_intrebare", referencedColumnName = "id_intrebare") })
	private Chestionare chestionar;

	// bi-directional many-to-one association to Pacienti
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pacient")
	private Pacienti pacienti;

	public RaspunsChestionar() {
	}

	public int getIdRaspunsChestionar() {
		return this.idRaspunsChestionar;
	}

	public void setIdRaspunsChestionar(int idRaspunsChestionar) {
		this.idRaspunsChestionar = idRaspunsChestionar;
	}

	public String getRaspuns() {
		return this.raspuns;
	}

	public void setRaspuns(String raspuns) {
		this.raspuns = raspuns;
	}

	public Chestionare getChestionar() {
		return chestionar;
	}

	public void setChestionar(Chestionare chestionar) {
		this.chestionar = chestionar;
	}

	public Pacienti getPacienti() {
		return this.pacienti;
	}

	public void setPacienti(Pacienti pacienti) {
		this.pacienti = pacienti;
	}

}