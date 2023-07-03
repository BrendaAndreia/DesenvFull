package com.example.edifice.ui;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import com.vaadin.flow.server.auth.AnonymousAllowed;

@Route("")
@AnonymousAllowed
public class HomeView extends VerticalLayout {

    public HomeView() {
        add(
                new H1("Home view"),
                new Button("Apartamento", event -> navigateToApartamentoView()),
                new Button("Edificio", event -> navigateToEdificioView()),
                new Button("Morador", event -> navigateToMoradorView())
        );
    }

    private void navigateToApartamentoView() {
        getUI().ifPresent(ui -> ui.navigate("apartamento"));
    }
    private void navigateToEdificioView() {
        getUI().ifPresent(ui -> ui.navigate("edificio"));
    }
    private void navigateToMoradorView() {
        getUI().ifPresent(ui -> ui.navigate("morador"));
    }
}

