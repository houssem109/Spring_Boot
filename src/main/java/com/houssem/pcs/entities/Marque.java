package com.houssem.pcs.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Marque {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMarque;
	
	private String nomMarque;
	@JsonIgnore
	@OneToMany(mappedBy = "marque")
	private List<Pc> pcs;

	
	
	


	public Long getIdMarque() {
		return idMarque;
	}


	public void setIdMarque(Long idMarque) {
		this.idMarque = idMarque;
	}


	public String getNomMarque() {
		return nomMarque;
	}


	public void setNomMarque(String nomMarque) {
		this.nomMarque = nomMarque;
	}


	public List<Pc> getPcs() {
		return pcs;
	}


	public void setPcs(List<Pc> pcs) {
		this.pcs = pcs;
	}
	
	

	
	
}
