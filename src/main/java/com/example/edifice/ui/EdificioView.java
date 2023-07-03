package com.example.edifice.ui;


import com.example.edifice.backend.edificio.Edificio;
import com.example.edifice.backend.edificio.EdificioService;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;
import org.vaadin.crudui.crud.impl.GridCrud;


@Route("edificio")
@RolesAllowed("ADMIN")
public class EdificioView extends VerticalLayout {
    public EdificioView(EdificioService service) {
        var crud = new GridCrud<>(Edificio.class, service);
        crud.getGrid().setColumns("nome","endereco");
        crud.getCrudFormFactory().setVisibleProperties("nome","endereco");
        add(
                new H1("Cadastro de Edifícios"),
                crud
        );
    }
}
