package org.vaadin.example.view;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.vaadin.example.model.Task;
import org.vaadin.example.model.TaskRepository;

@Route(value = "todo")
public class TodoView extends TodoDesign {

    private TaskRepository repository;
    private Task task = new Task();
    private Binder<Task> binder = new BeanValidationBinder<>(Task.class);

    private final ComponentEventListener<ClickEvent<Button>> addClicked = event -> {
        if (binder.validate().isOk()) {
            Checkbox checkbox = new Checkbox(textField.getValue());
            todoList.add(checkbox);

            repository.save(task);

            task = new Task();
            binder.setBean(task);
        }
    };

    @Autowired
    public TodoView(TaskRepository repository) {
        this.repository = repository;

        binder.bind(textField, "name");
        binder.setBean(task);

        showTasks();

        addButton.addClickListener(addClicked);
    }

    private void showTasks() {
        for (Task t : repository.findAll(Sort.by("id").ascending())) {
            Checkbox checkbox = new Checkbox(t.getName());
            todoList.add(checkbox);
        }
    }
}
