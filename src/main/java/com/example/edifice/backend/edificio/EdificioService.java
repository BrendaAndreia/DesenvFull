package com.example.edifice.backend.edificio;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.vaadin.crudui.crud.CrudListener;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class EdificioService implements CrudListener<Edificio> {

    private final EdificioRepository repository;

    @Override
    public Collection<Edificio> findAll() {
        return repository.findAll();
    }

    @Override
    public Edificio add(Edificio edificio) {
        return repository.save(edificio);
    }

    @Override
    public Edificio update(Edificio edificio) {
        return repository.save(edificio);
    }

    @Override
    public void delete(Edificio edificio) {
        repository.delete(edificio);
    }

}
