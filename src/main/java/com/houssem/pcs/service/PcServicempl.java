package com.houssem.pcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.houssem.pcs.entities.Pc;
import com.houssem.pcs.repos.PcRepository;
@Service
public class PcServicempl implements PcService{

	@Autowired
	PcRepository pcRepository;
	
	@Override
	public Pc savePc(Pc p) {
		return  pcRepository.save(p);

	}

	@Override
	public Pc updatePc(Pc p) {
		return  pcRepository.save(p);
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
	public Pc getPc(Long id) {
		return pcRepository.findById(id).get();
	}

	@Override
	public List<Pc> getAllPcs() {
		
		return pcRepository.findAll();
	}

}
