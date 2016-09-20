package com.filemanager.utils.transporters;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * The persistent class for the pacienti database table.
 * 
 */
@Entity
@NamedQuery(name = "Pacienti.findAll", query = "SELECT p FROM Pacienti p")
public class Pacienti implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String nume;

	private String prenume;

	// bi-directional many-to-one association to Consultatii
	@OneToMany(mappedBy = "pacienti", fetch=FetchType.LAZY)
	@Cascade({CascadeType.ALL})
	private List<Consultatii> consultatii;

	@OneToOne(mappedBy = "pacienti")
	@Cascade({CascadeType.ALL})
	private DetaliiPacient detaliiPacient;

	// bi-directional many-to-one association to Doctori
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_doctor")
	private Doctori doctori;

	@OneToOne(mappedBy = "pacienti")
	@Cascade({CascadeType.ALL})
	private RaspunsChestionar raspunsChestionar;

	public Pacienti() {
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

	public List<Consultatii> getConsultatii() {
		return this.consultatii;
	}

	public void setConsultatii(List<Consultatii> consultatii) {
		this.consultatii = consultatii;
	}

	public Consultatii addConsultatii(Consultatii consultatii) {
		getConsultatii().add(consultatii);
		consultatii.setPacienti(this);

		return consultatii;
	}

	public Consultatii removeConsultatii(Consultatii consultatii) {
		getConsultatii().remove(consultatii);
		consultatii.setPacienti(null);

		return consultatii;
	}

	public Doctori getDoctori() {
		return this.doctori;
	}

	public void setDoctori(Doctori doctori) {
		this.doctori = doctori;
	}

	public DetaliiPacient getDetaliiPacient() {
		return detaliiPacient;
	}

	public void setDetaliiPacient(DetaliiPacient detaliiPacient) {
		this.detaliiPacient = detaliiPacient;
	}

	public RaspunsChestionar getRaspunsChestionar() {
		return raspunsChestionar;
	}

	public void setRaspunsChestionar(RaspunsChestionar raspunsChestionar) {
		this.raspunsChestionar = raspunsChestionar;
	}

}