package com.example.edifice.backend.apartamento;

import com.example.edifice.backend.morador.Morador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartamentoRepository extends JpaRepository<Apartamento, Long>{

    boolean existsByMorador(Morador morador);
}
