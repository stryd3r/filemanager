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
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_doctor")
	private int idDoctor;

	private String nume;

	private String prenume;

	// bi-directional many-to-one association to Calendar
	@OneToOne(mappedBy = "doctor")
	private Calendar calendar;

	// bi-directional many-to-one association to Consultatii
	@OneToMany(mappedBy = "doctor")
	private List<Consultatii> consultatii;

	// bi-directional many-to-one association to Pacienti
	@OneToMany(mappedBy = "doctor")
	private List<Pacienti> pacienti;

	public Doctori() {
	}

	public int getIdDoctor() {
		return this.idDoctor;
	}

	public void setIdDoctor(int idDoctor) {
		this.idDoctor = idDoctor;
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


	public Consultatii addConsultatii(Consultatii consultatii) {
		getConsultatii().add(consultatii);
		consultatii.setDoctor(this);

		return consultatii;
	}

	public Consultatii removeConsultatii(Consultatii consultatii) {
		getConsultatii().remove(consultatii);
		consultatii.setDoctor(null);

		return consultatii;
	}

	public Pacienti addPacienti(Pacienti pacienti) {
		getPacienti().add(pacienti);
		pacienti.setDoctor(this);

		return pacienti;
	}

	public Pacienti removePacienti(Pacienti pacienti) {
		getPacienti().remove(pacienti);
		pacienti.setDoctor(null);

		return pacienti;
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

}