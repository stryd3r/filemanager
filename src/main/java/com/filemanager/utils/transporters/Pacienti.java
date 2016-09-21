package com.filemanager.utils.transporters;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_pacient")
	private int idPacient;

	private String nume;

	private String prenume;

	// bi-directional many-to-one association to Consultatii
	@OneToMany(mappedBy = "pacient")
	private List<Consultatii> consultatii;

	// bi-directional many-to-one association to DetaliiPacient
	@OneToOne(mappedBy = "pacient")
	@Cascade({CascadeType.ALL})
	private DetaliiPacient detaliiPacient;

	// bi-directional many-to-one association to Doctori
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_doctor")
	private Doctori doctor;

	// bi-directional many-to-one association to RaspunsChestionar
	@OneToOne(mappedBy = "pacienti")
	private RaspunsChestionar raspunsChestionar;

	public Pacienti() {
	}

	public int getIdPacient() {
		return this.idPacient;
	}

	public void setIdPacient(int idPacient) {
		this.idPacient = idPacient;
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
		consultatii.setPacient(this);

		return consultatii;
	}

	public Consultatii removeConsultatii(Consultatii consultatii) {
		getConsultatii().remove(consultatii);
		consultatii.setPacient(null);

		return consultatii;
	}

	public List<Consultatii> getConsultatii() {
		return consultatii;
	}

	public void setConsultatii(List<Consultatii> consultatii) {
		this.consultatii = consultatii;
	}

	public DetaliiPacient getDetaliiPacient() {
		return detaliiPacient;
	}

	public void setDetaliiPacient(DetaliiPacient detaliiPacient) {
		this.detaliiPacient = detaliiPacient;
	}

	public Doctori getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctori doctor) {
		this.doctor = doctor;
	}

	public RaspunsChestionar getRaspunsChestionar() {
		return raspunsChestionar;
	}

	public void setRaspunsChestionar(RaspunsChestionar raspunsChestionar) {
		this.raspunsChestionar = raspunsChestionar;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}