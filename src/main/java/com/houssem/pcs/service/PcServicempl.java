package com.houssem.pcs.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.houssem.pcs.dto.PcDTO;
import com.houssem.pcs.entities.Marque;
import com.houssem.pcs.entities.Pc;
import com.houssem.pcs.repos.MarqueRepository;
import com.houssem.pcs.repos.PcRepository;
@Service
public class PcServicempl implements PcService{

	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	PcRepository pcRepository;
	
	@Autowired
	MarqueRepository marqueRepository;
	
	@Override
	public PcDTO savePc(PcDTO p) {
		return convertEntityToDto( pcRepository.save(convertDtoToEntity(p)));

	}
	@Override
	public PcDTO getPc(Long id) {
		return  convertEntityToDto(pcRepository.findById(id).get());
	}

	@Override
	public List<PcDTO> getAllPcs() {
		
		return pcRepository.findAll().stream().map(this::convertEntityToDto)
				.collect(Collectors.toList());
		//OU BIEN
		/*List<Pc> pcs = pcRepository.findAll();
		List<PcDTO> listpcDto = new ArrayList<>(pcs.size());
		for (Pc p : pcs)
		listpcDto.add(convertEntityToDto(p));
		return listpcDto;*/

	}

	@Override
	public PcDTO updatePc(PcDTO p) {
		return convertEntityToDto( pcRepository.save(convertDtoToEntity(p)));
	}

	@Override
	public void deletePc(Pc p) {
		pcRepository.delete(p);		
	}

	@Override
	public void deletePcById(Long id) {
		pcRepository.deleteById(id);		
	}

	
	@Override
	public List<Pc> findByModele(String modele) {
		return pcRepository.findByModele(modele);
	}

	@Override
	public List<Pc> findByModeleContains(String modele) {
		return pcRepository.findByModeleContains(modele);
	}

	@Override
	public List<Pc> findByModelePrix(String modele, Double prix) {
		return pcRepository.findByModelePrix(modele,prix);
	}

	@Override
	public List<Pc> findByMarque(Marque marque) {
		return pcRepository.findByMarque(marque);
	}

	@Override
	public List<Pc> findByMarqueIdMarque(Long id) {
		return pcRepository.findByMarqueIdMarque(id);
	}

	@Override
	public List<Pc> findByOrderByModeleAsc() {
		return pcRepository.findByOrderByModeleAsc();
	}

	@Override
	public List<Pc> trierModelePrix() {
		return pcRepository.trierModelePrix();
	}

	@Override
	public Page<Pc> getAllPcsParPage(int page, int size) {
		
		return pcRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public List<Marque> getAllMarques() {
		return marqueRepository.findAll();

	}

	@Override
	public PcDTO convertEntityToDto(Pc p) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		PcDTO pcDTO = modelMapper.map(p, PcDTO.class);
		 return pcDTO;
		 }

	
		/*PcDTO pcDTO = new PcDTO();
		pcDTO.setIdPc(p.getIdPc());
		pcDTO.setMarque(p.getMarque());
		pcDTO.setModele(p.getModele());
		pcDTO.setProcesseur(p.getProcesseur());
		pcDTO.setMemoireRAM(p.getMemoireRAM());
		pcDTO.setCapaciteStockage(p.getCapaciteStockage());
		pcDTO.setCarteGraphique(p.getCarteGraphique());
		pcDTO.setSystemeExploitation(p.getSystemeExploitation());
		pcDTO.setPrix(p.getPrix());
		pcDTO.setDateAchat(p.getDateAchat());
		pcDTO.setEmail(p.getEmail());*/
		/*
		return PcDTO.builder()
				.idPc(p.getIdPc())
				.marque(p.getMarque())
				//.nomMarque(p.getMarque().getNomMarque())
				.modele(p.getModele())
				.processeur(p.getProcesseur())
				.memoireRAM(p.getMemoireRAM())
				.capaciteStockage(p.getCapaciteStockage())
				.carteGraphique(p.getCarteGraphique())
				.systemeExploitation(p.getSystemeExploitation())
				.prix(p.getPrix())
				.dateAchat(p.getDateAchat())
				.email(p.getEmail())
				.build();
	}*/
	@Override
	public Pc convertDtoToEntity(PcDTO pcDTO) {
		Pc pc = new Pc();
		pc = modelMapper.map(pcDTO, Pc.class);
		return pc;

		/*pc.setIdPc(pcDTO.getIdPc());
		pc.setMarque(pcDTO.getMarque());
		pc.setModele(pcDTO.getModele());
		pc.setProcesseur(pcDTO.getProcesseur());
		pc.setMemoireRAM(pcDTO.getMemoireRAM());
		pc.setCapaciteStockage(pcDTO.getCapaciteStockage());
		pc.setCarteGraphique(pcDTO.getCarteGraphique());
		pc.setSystemeExploitation(pcDTO.getSystemeExploitation());
		pc.setPrix(pcDTO.getPrix());
		pc.setDateAchat(pcDTO.getDateAchat());
		pc.setEmail(pcDTO.getEmail());*/
	}

}
