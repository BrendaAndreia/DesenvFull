package com.example.edifice.ui;

import com.example.edifice.backend.apartamento.Apartamento;
import com.example.edifice.backend.apartamento.ApartamentoService;
import com.example.edifice.backend.edificio.Edificio;
import com.example.edifice.backend.edificio.EdificioService;
import com.example.edifice.backend.morador.Morador;
import com.example.edifice.backend.morador.MoradorService;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;
import org.vaadin.crudui.crud.impl.GridCrud;

@Route("apartamento")
@RolesAllowed("ADMIN")
public class ApartamentoView extends VerticalLayout {
    public ApartamentoView(ApartamentoService apartamentoService, MoradorService moradorService, EdificioService edificioService) {

        GridCrud<Apartamento> crud = new GridCrud<>(Apartamento.class, apartamentoService);
        crud.getGrid().setColumns("numero", "andar", "metragem", "situacao", "morador", "edificio");
        crud.getCrudFormFactory().setVisibleProperties("numero", "andar", "metragem", "situacao", "morador", "edificio");

        add(
                new H1("Cadastro de Apartamentos"),
                crud
        );

        // Configurar ComboBox para o campo "morador" no formulário de criação/edição
        ComboBox<Morador> moradorComboBox = new ComboBox<>("Selecione um Morador");
        moradorComboBox.setItems(moradorService.findAll());
        crud.getCrudFormFactory().setFieldProvider("morador", field -> {
            moradorComboBox.setItems(moradorService.findAll());
            return moradorComboBox;
        });



        // Configurar ComboBox para o campo "edificio" no formulário de criação/edição
        ComboBox<Edificio> edificioComboBox = new ComboBox<>("Selecione um Edifício");
        edificioComboBox.setItems(edificioService.findAll());
        crud.getCrudFormFactory().setFieldProvider("edificio", (field) -> {
            edificioComboBox.setItems(edificioService.findAll());
            return edificioComboBox;
        });


        //Styles

    }
}
