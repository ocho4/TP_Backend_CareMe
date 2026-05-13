package com.upc.fc.tp_careme.repositorios;

import com.upc.fc.tp_careme.entidades.HorarioCuidador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioCuidadorRepository extends JpaRepository<HorarioCuidador, Integer> {
}
