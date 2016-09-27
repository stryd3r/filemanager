package com.filemanager.utils.transporters.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * The persistent class for the detalii_pacient database table.
 * 
 */
@Entity
@Table
@NamedQuery(name = "PacientDetail.findAll", query = "SELECT d FROM PacientDetail d")
public class PacientDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pacientDetailsId;

	private String address;

	@OneToOne
	@JoinColumn(name = "pacientId",referencedColumnName="pacientId")
	@JsonBackReference
	private Pacient pacient;

	public PacientDetail() {
	}

	public Pacient getPacient() {
		return pacient;
	}

	public void setPacient(Pacient pacient) {
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