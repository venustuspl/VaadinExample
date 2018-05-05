package com.gwidgets.demo.ui;

import com.gwidgets.demo.CarRepository;
import com.gwidgets.demo.model.Car;
import com.vaadin.data.provider.DataProvider;
import com.vaadin.navigator.View;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class Add extends Composite implements View {

    @Autowired
    CarRepository repository;

    @Autowired
    DataProvider dataProvider;

    @PostConstruct
    public void init() {
        FormLayout formLayout = new FormLayout();
        Label title = new Label("Add new Car");
        TextField brandInput = new TextField("Brand: ");
        TextField modelInput = new TextField("Model: ");
        TextField pictureLinkInput = new TextField("Picture Link: ");
        Button button = new Button("Add", clickEvent -> {
            repository.save(new Car(brandInput.getValue(), modelInput.getValue(), pictureLinkInput.getValue()));
            Notification.show("saved");
        });
        formLayout.addComponent(title);
        formLayout.addComponent(brandInput);
        formLayout.addComponent(modelInput);
        formLayout.addComponent(pictureLinkInput);
        formLayout.addComponent(button);
        setCompositionRoot(formLayout);
    }
}