package com.houssem.pcs.dto;

import java.util.Date;

import com.houssem.pcs.entities.Marque;

import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PcDTO {
	private Long idPc;
	private Marque marque;
	private String modele;
	private String processeur;
	private int memoireRAM;
	private int capaciteStockage;
	private String carteGraphique;
	private String systemeExploitation;
	private double prix;
	private Date dateAchat;
	private String email;

	private String nomMarque;
}
