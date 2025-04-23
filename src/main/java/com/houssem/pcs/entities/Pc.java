package com.houssem.pcs.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

@Entity
public class Pc {
	public Pc(Marque marque, String modele, String processeur, int memoireRAM, int capaciteStockage,
			String carteGraphique, String systemeExploitation, double prix, Date dateAchat, String email) {
		super();
		this.marque = marque;
		this.modele = modele;
		this.processeur = processeur;
		this.memoireRAM = memoireRAM;
		this.capaciteStockage = capaciteStockage;
		this.carteGraphique = carteGraphique;
		this.systemeExploitation = systemeExploitation;
		this.prix = prix;
		this.dateAchat = dateAchat;
		this.email = email;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPc;

	@NotNull
	@ManyToOne
	private Marque marque;

	@NotNull
	@Size(min = 2, max = 30)
	private String modele;

	@NotNull
	@Size(min = 2, max = 50)
	private String processeur;

	@NotNull
	@Min(value = 1)
	@Max(value = 128)
	private int memoireRAM;

	@NotNull
	@Min(value = 128)
	@Max(value = 10000)
	private int capaciteStockage;

	@Size(max = 100)
	@NotNull
	private String carteGraphique;

	@NotNull
	@Size(min = 2, max = 50)
	private String systemeExploitation;

	@NotNull
	@Min(value = 200)
	@Max(value = 10000)
	private double prix;

	@NotNull
	@PastOrPresent
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateAchat;

	@NotNull
	private String email;

	public Pc() {
		super();
	}

	public Long getIdPc() {
		return idPc;
	}

	public void setIdPc(Long idPc) {
		this.idPc = idPc;
	}

	public Marque getMarque() {
		return marque;
	}

	public void setMarque(Marque marque) {
		this.marque = marque;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public String getProcesseur() {
		return processeur;
	}

	public void setProcesseur(String processeur) {
		this.processeur = processeur;
	}

	public int getMemoireRAM() {
		return memoireRAM;
	}

	public void setMemoireRAM(int memoireRAM) {
		this.memoireRAM = memoireRAM;
	}

	public int getCapaciteStockage() {
		return capaciteStockage;
	}

	public void setCapaciteStockage(int capaciteStockage) {
		this.capaciteStockage = capaciteStockage;
	}

	public String getCarteGraphique() {
		return carteGraphique;
	}

	public void setCarteGraphique(String carteGraphique) {
		this.carteGraphique = carteGraphique;
	}

	public String getSystemeExploitation() {
		return systemeExploitation;
	}

	public void setSystemeExploitation(String systemeExploitation) {
		this.systemeExploitation = systemeExploitation;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Date getDateAchat() {
		return dateAchat;
	}

	public void setDateAchat(Date dateAchat) {
		this.dateAchat = dateAchat;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Pc [idPc=" + idPc + ", marque=" + (marque != null ? marque.getNomMarque() : "null") + ", modele="
				+ modele + ", processeur=" + processeur + ", memoireRAM=" + memoireRAM + ", capaciteStockage="
				+ capaciteStockage + ", carteGraphique=" + carteGraphique + ", systemeExploitation="
				+ systemeExploitation + ", prix=" + prix + ", dateAchat=" + dateAchat + ", email=" + email + "]";
	}

}
