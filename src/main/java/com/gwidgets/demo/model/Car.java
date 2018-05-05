package com.gwidgets.demo.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Car {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator", parameters = {@Parameter(name="uuid_gen_strategy_class", value="org.hibernate.id.uuid.CustomVersionOneStrategy")})
    String id;

    String brand;

    String model;

    String pictureLink;

    public Car() {
    }

    public Car(String brand, String model, String pictureLink) {
        this.brand = brand;
        this.model = model;
        this.pictureLink = pictureLink;
    }

    public String getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getPictureLink() {
        return pictureLink;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPictureLink(String pictureLink) {
        this.pictureLink = pictureLink;
    }
}
