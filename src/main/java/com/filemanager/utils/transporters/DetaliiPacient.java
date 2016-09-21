package com.filemanager.utils.transporters;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the detalii_pacient database table.
 * 
 */
@Entity
@Table(name = "detalii_pacient")
@NamedQuery(name = "DetaliiPacient.findAll", query = "SELECT d FROM DetaliiPacient d")
public class DetaliiPacient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_detalii_pacient")
	private int idDetaliiPacient;

	private String adresa;

	// bi-directional many-to-one association to Pacienti
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pacient")
	private Pacienti pacient;

	public DetaliiPacient() {
	}

	public int getIdDetaliiPacient() {
		return this.idDetaliiPacient;
	}

	public void setIdDetaliiPacient(int idDetaliiPacient) {
		this.idDetaliiPacient = idDetaliiPacient;
	}

	public String getAdresa() {
		return this.adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public Pacienti getPacient() {
		return pacient;
	}

	public void setPacient(Pacienti pacient) {
		this.pacient = pacient;
	}

}