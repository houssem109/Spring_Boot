package com.houssem.pcs.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.houssem.pcs.entities.Pc;

public interface PcRepository extends JpaRepository<Pc, Long> {

}
