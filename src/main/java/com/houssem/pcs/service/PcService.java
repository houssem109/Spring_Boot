package com.houssem.pcs.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.houssem.pcs.dto.PcDTO;
import com.houssem.pcs.entities.Marque;
import com.houssem.pcs.entities.Pc;

public interface PcService {
	
	
	PcDTO updatePc(PcDTO p);
	PcDTO savePc(PcDTO p);
	PcDTO getPc(Long id);
	List<PcDTO> getAllPcs();

	void deletePc(Pc p);

	void deletePcById(Long id);

	
	List<Pc> findByModele(String modele);
	List<Pc> findByModeleContains(String modele);
	List<Pc> findByModelePrix (String modele, Double prix);
	List<Pc> findByMarque (Marque marque);
	List<Pc> findByMarqueIdMarque(Long id);
	List<Pc> findByOrderByModeleAsc();
	List<Pc> trierModelePrix ();
	
	Page<Pc> getAllPcsParPage(int page, int size);
	List<Marque> getAllMarques();

	PcDTO convertEntityToDto (Pc p);
	
	Pc convertDtoToEntity(PcDTO pcDTO);

}
