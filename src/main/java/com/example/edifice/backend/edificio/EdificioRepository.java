package com.example.edifice.backend.edificio;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EdificioRepository extends JpaRepository<Edificio, Long>{

}
