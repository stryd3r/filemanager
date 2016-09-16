package com.filemanager.utils.transporters.dto;

import java.io.Serializable;
import java.util.List;

import com.filemanager.backend.entities.Consultatii;
import com.filemanager.backend.entities.DetaliiPacient;
import com.filemanager.backend.entities.Doctori;

public class PacientiDto extends DetaliiPacientDto implements Serializable{

	private static final long serialVersionUID = -986647579595008421L;
	private int id;
	private String nume;
	private String prenume;
	private DetaliiPacient detaliiPacient = new DetaliiPacient();
	private Doctori doctor;
	private List<Consultatii> consultatii;

	public List<Consultatii> getConsultatii() {
		return consultatii;
	}

	public void setConsultatii(List<Consultatii> consultatii) {
		this.consultatii = consultatii;
	}

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
}
