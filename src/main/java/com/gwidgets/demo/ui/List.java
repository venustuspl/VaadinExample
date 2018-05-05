package com.gwidgets.demo.ui;

import com.gwidgets.demo.CarRepository;
import com.gwidgets.demo.model.Car;
import com.vaadin.data.ValueProvider;
import com.vaadin.data.provider.DataProvider;
import com.vaadin.navigator.View;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.Composite;
import com.vaadin.ui.Grid;
import com.vaadin.ui.renderers.ImageRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class List extends Composite implements View {

    @Autowired
    CarRepository repository;

    @Autowired
    DataProvider dataProvider;

    @PostConstruct
    public void init() {

        Grid<Car> carGrid = new Grid<>();
        carGrid.setWidth("100%");
        carGrid.setHeight("100%");
        carGrid.setDataProvider(dataProvider);
        carGrid.addColumn(Car::getId).setCaption("Id");
        carGrid.addColumn(Car::getBrand).setCaption("Brand");
        carGrid.addColumn(Car::getModel).setCaption("Model");
        carGrid.addColumn((ValueProvider<Car, Object>) car -> new ExternalResource(car.getPictureLink())).setCaption("Picture").setRenderer(new ImageRenderer()).setResizable(true);
        setCompositionRoot(carGrid);
        setSizeFull();
    }
}