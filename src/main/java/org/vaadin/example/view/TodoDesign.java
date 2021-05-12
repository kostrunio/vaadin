package org.vaadin.example.view;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class TodoDesign extends VerticalLayout {
    protected VerticalLayout todoList = new VerticalLayout();
    protected TextField textField = new TextField();
    protected Button addButton = new Button("Add");

    public TodoDesign() {
        createMainLayout();
        addButton.addClickShortcut(Key.ENTER);
        addButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
    }

    private void createMainLayout() {
        add(new H1("Vaadin Todo"), todoList, createAddLayout());
    }

    private Component createAddLayout() {
        HorizontalLayout layout = new HorizontalLayout();
        layout.add(textField, addButton);
        return layout;
    }
}
