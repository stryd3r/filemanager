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

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
public class Doctori implements Serializable {

	private static final long serialVersionUID = 466868757207463484L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nume;
	private String prenume;

	@OneToMany(fetch = FetchType.LAZY)
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JoinColumn(name="id", insertable=false,updatable=false)
	private List<Pacienti> pacienti;

	@OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY)
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<Consultatii> consultatii;

	@OneToOne
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
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

	public List<Consultatii> getConsultatii() {
		return consultatii;
	}

	public void setConsultatii(List<Consultatii> consultatii) {
		this.consultatii = consultatii;
	}

	public Calendar getCalendar() {
		return calendar;
	}

	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}

}
