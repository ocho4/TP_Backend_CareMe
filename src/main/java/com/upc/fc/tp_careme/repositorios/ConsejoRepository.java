package com.upc.fc.tp_careme.repositorios;

import com.upc.fc.tp_careme.entidades.Consejo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsejoRepository extends JpaRepository<Consejo, Integer> {
}