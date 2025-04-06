package com.houssem.pcs.repos;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.houssem.pcs.entities.Pc;

public interface PcRepository extends JpaRepository<Pc, Long> {
	List<Pc> findByModele(String modele);
	List<Pc> findByModeleContains(String modele);

}
