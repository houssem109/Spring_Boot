package com.houssem.pcs;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.houssem.pcs.entities.Pc;
import com.houssem.pcs.repos.PcRepository;

@SpringBootTest
class PcsApplicationTests {

	@Autowired
	private PcRepository pcRepository;

	@Test
	public void testCreatePc() {
		Pc pc1 = new Pc("MSI", "gf63", "i5-11400H", 24, 512, "Nvidia GeForce GTX 1650", "Windows 10 Professionnel",
				2900.00, new Date(), // Current date
				"houssembenjaafar105@gmail.com");
		pcRepository.save(pc1);

		// Create second PC entry
		Pc pc2 = new Pc(

				"GIGI", "G5 KF5", "i5-13500H", 16, 1024, "Nvidia GeForce RTX 4060", "Windows 11 Professionnel", 3159.00,
				new Date(), // Current date
				"houssembenjaafar109@gmail.com");
		pcRepository.save(pc2);
	}

	
	@Test
	public void testListerTousPcs1()
	{
		List<Pc>
		pcs = pcRepository.findAll();
		for (Pc p : pcs)
		{
			System.out.println(p);
		}
	}
	
	@Test
	public void testFindPc() {
		Pc p = pcRepository.findById(1L).get();
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
	public void testListerTousPcs()
	{
		List<Pc>
		pcs = pcRepository.findAll();
		for (Pc p : pcs)
		{
			System.out.println(p);
		}
	}
}