package com.upc.fc.tp_careme.repositorios;

import com.upc.fc.tp_careme.entidades.Familiar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamiliarRepository extends JpaRepository<Familiar, Integer> {
}