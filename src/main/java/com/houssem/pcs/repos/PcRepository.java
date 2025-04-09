package com.houssem.pcs.repos;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.houssem.pcs.entities.Marque;
import com.houssem.pcs.entities.Pc;


@RepositoryRestResource(path = "rest")
public interface PcRepository extends JpaRepository<Pc, Long> {
	List<Pc> findByModele(String modele);
	List<Pc> findByModeleContains(String modele);
	/*@Query("select p from Pc p where p.modele like %?1 and p.prix > ?2")
	List<Pc> findByModelePrix (String modele, Double prix);*/

	@Query("select p from Pc p where p.modele like %:modele and p.prix > :prix")
	List<Pc> findByModelePrix (@Param("modele") String nom,@Param("prix") Double prix);


	
	@Query("select p from Pc p where p.marque = ?1")
	List<Pc> findByMarque (Marque marque);
	
	List<Pc> findByMarqueIdMarque(Long id);

	List<Pc> findByOrderByModeleAsc();
	
	@Query("select p from Pc p order by p.modele ASC, p.prix DESC")
	List<Pc> trierModelePrix ();
}