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
	private int id;

	private String adresa;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pacient")
	private Pacienti pacienti;

	public DetaliiPacient() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdresa() {
		return this.adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public Pacienti getPacienti() {
		return this.pacienti;
	}

	public void setPacienti(Pacienti pacienti) {
		this.pacienti = pacienti;
	}

}