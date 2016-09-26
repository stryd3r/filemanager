package com.filemanager.utils.transporters.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the detalii_pacient database table.
 * 
 */
@Entity
@Table
@NamedQuery(name = "PacientsDetails.findAll", query = "SELECT d FROM PacientsDetails d")
public class PacientsDetails implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pacientDetailsId;

	private String address;

	// bi-directional many-to-one association to Pacienti
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pacientId")
	private Pacients pacient;

	public PacientsDetails() {
	}

	public Pacients getPacient() {
		return pacient;
	}

	public void setPacient(Pacients pacient) {
		this.pacient = pacient;
	}

	public int getPacientDetailsId() {
		return pacientDetailsId;
	}

	public void setPacientDetailsId(int pacientDetailsId) {
		this.pacientDetailsId = pacientDetailsId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}