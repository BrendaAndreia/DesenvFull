package com.example.edifice.backend.apartamento;
import com.example.edifice.backend.morador.Morador;
import com.vaadin.flow.component.notification.Notification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.vaadin.crudui.crud.CrudListener;
import java.util.Collection;


@Service
@RequiredArgsConstructor
public class ApartamentoService implements CrudListener<Apartamento> {

    private final ApartamentoRepository repository;

    @Override
    public Collection<Apartamento> findAll() {
        return repository.findAll();
    }

    @Override
    public Apartamento add(Apartamento apartamento) {

        Morador morador = apartamento.getMorador();

        // Verifica se o morador já está cadastrado em outro apartamento
        if (isMoradorCadastrado(morador)) {
            Notification.show("O morador já está cadastrado em outro apartamento.",3000, Notification.Position.TOP_CENTER);

        }

        return repository.save(apartamento);
    }

    @Override
    public Apartamento update(Apartamento apartamento) {

        Morador morador = apartamento.getMorador();

        // Verifica se o morador já está cadastrado em outro apartamento
        if (isMoradorCadastrado(morador)) {
            Notification notification = new Notification ("O morador já está cadastrado em outro apartamento.",3000, Notification.Position.TOP_CENTER);
            notification.open();
        }
        return repository.save(apartamento);
    }

    @Override
    public void delete(Apartamento apartamento) {
        repository.delete(apartamento);
    }

    // Verifica se o morador já está cadastrado em outro apartamento
    private boolean isMoradorCadastrado(Morador morador) {
        return repository.existsByMorador(morador);
    }

}
