package com.example.edifice.ui;

import com.example.edifice.backend.apartamento.Apartamento;
import com.example.edifice.backend.apartamento.ApartamentoService;
import com.example.edifice.backend.morador.Morador;
import com.example.edifice.backend.morador.MoradorService;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;

import org.vaadin.crudui.crud.impl.GridCrud;


@Route("morador")
@RolesAllowed("ADMIN")

public class MoradorView extends VerticalLayout {
    public MoradorView(MoradorService moradorService, ApartamentoService apartamentoService) {
        H1 titulo = new H1("Cadastro de Moradores");

        GridCrud<Morador> crud = new GridCrud<>(Morador.class, moradorService);
        crud.getGrid().setColumns("nome", "cpf", "telefone");

        add(titulo, crud);
    }
}
