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
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String nume;

	private String prenume;

	// bi-directional many-to-one association to Calendar
	@OneToOne(mappedBy = "doctori")
	private Calendar calendar;

	// bi-directional many-to-one association to Consultatii
	@OneToMany(mappedBy = "doctori")
	private List<Consultatii> consultatii;

	// bi-directional many-to-one association to Pacienti
	@OneToMany(mappedBy = "doctori")
	private List<Pacienti> pacienti;

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

	public List<Consultatii> getConsultatii() {
		return consultatii;
	}

	public void setConsultatii(List<Consultatii> consultatii) {
		this.consultatii = consultatii;
	}

	public List<Pacienti> getPacienti() {
		return pacienti;
	}

	public void setPacienti(List<Pacienti> pacienti) {
		this.pacienti = pacienti;
	}

	public Consultatii addConsultatii(Consultatii consultatii) {
		getConsultatii().add(consultatii);
		consultatii.setDoctori(this);

		return consultatii;
	}

	public Consultatii removeConsultatii(Consultatii consultatii) {
		getConsultatii().remove(consultatii);
		consultatii.setDoctori(null);

		return consultatii;
	}


	public Pacienti addPacienti(Pacienti pacienti) {
		getPacienti().add(pacienti);
		pacienti.setDoctori(this);

		return pacienti;
	}

	public Pacienti removePacienti(Pacienti pacienti) {
		getPacienti().remove(pacienti);
		pacienti.setDoctori(null);

		return pacienti;
	}

}