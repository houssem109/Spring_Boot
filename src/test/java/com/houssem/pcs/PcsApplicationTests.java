package com.houssem.pcs;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.houssem.pcs.entities.Marque;
import com.houssem.pcs.entities.Pc;
import com.houssem.pcs.repos.PcRepository;
import com.houssem.pcs.service.PcService;

@SpringBootTest
class PcsApplicationTests {

	@Autowired
	private PcRepository pcRepository;
	@Autowired
	private PcService pcService;

	@Test
	public void testCreatePc() {
		/*
		 * Pc pc1 = new Pc("MSI", "gf63", "i5-11400H", 24, 512,
		 * "Nvidia GeForce GTX 1650", "Windows 10 Professionnel", 2900.00, new Date(),
		 * // Current date "houssembenjaafar105@gmail.com"); pcRepository.save(pc1);
		 * 
		 * // Create second PC entry Pc pc2 = new Pc(
		 * 
		 * "GIGI", "G5 KF5", "i5-13500H", 16, 1024, "Nvidia GeForce RTX 4060",
		 * "Windows 11 Professionnel", 3159.00, new Date(), // Current date
		 * "houssembenjaafar109@gmail.com"); pcRepository.save(pc2);
		 * 
		 * 
		 * Pc pc3 = new Pc("lonovo", "log", "i5-11400H", 24, 512,
		 * "Nvidia GeForce GTX 1650", "Windows 10 Professionnel", 2900.00, new Date(),
		 * // Current date "houssembenjaafar105@gmail.com"); pcRepository.save(pc3);
		 */
	}

	@Test
	public void testFindPc() {
		Pc p = pcRepository.findById(2L).get();
		System.out.println(p);
	}

	@Test
	public void testUpdatePc() {
		Pc p = pcRepository.findById(2L).get();
		p.setPrix(1000.0);
		pcRepository.save(p);
	}

	@Test
	public void testDeletePc() {
		pcRepository.deleteById(1L);
		;
	}

	@Test
	public void testListerTousPcs() {
		List<Pc> pcs = pcRepository.findAll();
		for (Pc p : pcs) {
			System.out.println(p);
		}
	}

	@Test
	public void testFindByMarquePcContains() {
		Page<Pc> pcs = pcService.getAllPcsParPage(0, 2);
		System.out.println(pcs.getSize());
		System.out.println(pcs.getTotalElements());
		System.out.println(pcs.getTotalPages());
		pcs.getContent().forEach(p -> {
			System.out.println(p.toString());
		});
		/*
		 * ou bien for (Pc p : pcs) { System.out.println(p); }
		 */
	}

	@Test
	public void testFindPcByModele() {
		System.out.println("find pc by modele");

		List<Pc> pcs = pcRepository.findByModele("GF63");
		for (Pc p : pcs) {
			System.out.println(p);
		}
	}

	@Test
	public void testFindPcByModeleContains() {
		System.out.println("find pc by modele ( letter)");

		List<Pc> pcs = pcRepository.findByModeleContains("G");
		for (Pc p : pcs) {
			System.out.println(p);
		}
	}

	@Test
	public void testfindByModelePrix() {
		List<Pc> pcs = pcRepository.findByModelePrix("GF63", 900.0);
		for (Pc p : pcs) {
			System.out.println(p);
		}
	}

	@Test
	public void testfindByMarque() {
		Marque mar = new Marque();
		mar.setIdMarque(4L);
		List<Pc> pcs = pcRepository.findByMarque(mar);
		for (Pc p : pcs) {
			System.out.println(p);
		}
	}

	@Test
	public void findByMarqueIdMarque() {
		List<Pc> pcs = pcRepository.findByMarqueIdMarque(4L);
		for (Pc p : pcs) {
			System.out.println(p);
		}
	}

	@Test
	public void findByOrderByModeleAsc() {
		List<Pc> pcs = pcRepository.findByOrderByModeleAsc();
		for (Pc p : pcs) {
			System.out.println(p);
		}
	}

	@Test
	public void trierModelePrix() {
		List<Pc> pcs = pcRepository.trierModelePrix();
		for (Pc p : pcs) {
			System.out.println(p);
		}
	}

}