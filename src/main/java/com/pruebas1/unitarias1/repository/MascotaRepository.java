package com.pruebas1.unitarias1.repository;

import com.pruebas1.unitarias1.model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Long> {}
