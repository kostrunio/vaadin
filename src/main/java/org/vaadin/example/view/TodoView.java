package org.vaadin.example.view;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.router.Route;

@Route(value = "todo")
public class TodoView extends TodoDesign {

    private final ComponentEventListener<ClickEvent<Button>> addClicked = event -> {
        Checkbox checkbox = new Checkbox(textField.getValue());
        todoList.add(checkbox);
        textField.clear();
    };

    public TodoView() {
        addButton.addClickListener(addClicked);
    }
}
