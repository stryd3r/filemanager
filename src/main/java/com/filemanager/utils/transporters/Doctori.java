package com.filemanager.utils.transporters;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the doctori database table.
 * 
 */
@Entity
@NamedQuery(name = "Doctori.findAll", query = "SELECT d FROM Doctori d")
public class Doctori implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String nume;

	private String prenume;

	// bi-directional many-to-one association to Calendar
	@OneToOne(mappedBy = "doctori")
	private Calendar calendar;

	// bi-directional many-to-one association to Consultatii
	@OneToMany(mappedBy = "doctori")
	private List<Consultatii> consultatiis;

	// bi-directional many-to-one association to Pacienti
	@OneToMany(mappedBy = "doctori")
	private List<Pacienti> pacientis;

	public Doctori() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNume() {
		return this.nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPrenume() {
		return this.prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public Calendar getCalendar() {
		return calendar;
	}

	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}

	public List<Consultatii> getConsultatiis() {
		return this.consultatiis;
	}

	public void setConsultatiis(List<Consultatii> consultatiis) {
		this.consultatiis = consultatiis;
	}

	public Consultatii addConsultatii(Consultatii consultatii) {
		getConsultatiis().add(consultatii);
		consultatii.setDoctori(this);

		return consultatii;
	}

	public Consultatii removeConsultatii(Consultatii consultatii) {
		getConsultatiis().remove(consultatii);
		consultatii.setDoctori(null);

		return consultatii;
	}

	public List<Pacienti> getPacientis() {
		return this.pacientis;
	}

	public void setPacientis(List<Pacienti> pacientis) {
		this.pacientis = pacientis;
	}

	public Pacienti addPacienti(Pacienti pacienti) {
		getPacientis().add(pacienti);
		pacienti.setDoctori(this);

		return pacienti;
	}

	public Pacienti removePacienti(Pacienti pacienti) {
		getPacientis().remove(pacienti);
		pacienti.setDoctori(null);

		return pacienti;
	}

}