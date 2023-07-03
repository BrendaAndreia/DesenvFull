    package com.example.edifice.backend.apartamento;
    import com.example.edifice.backend.edificio.Edificio;
    import com.example.edifice.backend.morador.Morador;
    import jakarta.persistence.*;
    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.NoArgsConstructor;

    import java.util.List;


    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode(onlyExplicitlyIncluded = true)
    @Entity
    @Data

    @Table(name = "apartamento")
    public class Apartamento {

        @EqualsAndHashCode.Include
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

        private Long id;
        private String nome;
        private int numero;
        private int andar;
        double metragem;
        String situacao;

        @OneToOne
        @JoinColumn(name = "morador_id")
        private Morador morador;

        @ManyToOne
        @JoinColumn(name = "edificio_id")
        private Edificio edificio;
    }
