package com.houssem.pcs.entities;

import org.springframework.data.rest.core.config.Projection;
@Projection(name="modele", types= {Pc.class})
 
public interface PcProjection {
	public String getModele();
}
