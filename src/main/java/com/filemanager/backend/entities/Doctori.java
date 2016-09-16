package com.filemanager.backend.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Doctori implements Serializable {

	private static final long serialVersionUID = 466868757207463484L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nume;
	private String prenume;

	@OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY)
	private List<Pacienti> pacienti;

	@OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY)
	private List<Consultatii> consultatii;

	@OneToOne
	private Calendar calendar;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public List<Pacienti> getPacienti() {
		return pacienti;
	}

	public void setPacienti(List<Pacienti> pacienti) {
		this.pacienti = pacienti;
	}

}
