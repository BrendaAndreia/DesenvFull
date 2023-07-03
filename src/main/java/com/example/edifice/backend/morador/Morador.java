package com.example.edifice.backend.morador;
import com.example.edifice.backend.apartamento.Apartamento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Data

@Table(name = "morador")
public class Morador {


    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Long id;
    private String nome;
    private String cpf;
    private String telefone;

    @OneToOne
    @JoinColumn(name = "apartamento_id")
    private Apartamento apartamento;

    @Override
    public String toString() {
        return
                 nome;
    }
}
