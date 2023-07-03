package com.example.edifice.backend.edificio;

import com.example.edifice.backend.apartamento.Apartamento;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity

@Table(name = "edificio")

public class Edificio {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nome;
    private String endereco;

    @OneToMany(mappedBy = "edificio", cascade = CascadeType.ALL)
    private List<Apartamento> apartamentos;

    @Override
    public String toString() {
        return
                 nome;
    }
}
