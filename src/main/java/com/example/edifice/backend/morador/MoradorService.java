package com.example.edifice.backend.morador;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.vaadin.crudui.crud.CrudListener;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class MoradorService implements CrudListener<Morador> {

    private final MoradorRepository repository;

    @Override
    public Collection<Morador> findAll() {
        return repository.findAll();
    }

    @Override
    public Morador add(Morador morador) {
        return repository.save(morador);
    }

    @Override
    public Morador update(Morador morador) {
        return repository.save(morador);
    }

    @Override
    public void delete(Morador morador) {
        repository.delete(morador);
    }
}
