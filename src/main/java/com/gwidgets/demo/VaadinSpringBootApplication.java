package com.gwidgets.demo;

import com.gwidgets.demo.model.Car;
import com.gwidgets.demo.ui.Main;
import com.vaadin.data.provider.CallbackDataProvider;
import com.vaadin.data.provider.DataProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class VaadinSpringBootApplication {

	@Autowired
	CarRepository repository;


	public static void main(String[] args) {
		SpringApplication.run(VaadinSpringBootApplication.class, args);
	}


	@Bean
	public CommandLineRunner insertSampleDate() {
		return args -> {
			repository.save(new Car("Mercedes", "2014", "https://www.mbworld.co.za/mercedes-amg/uploadedImages/Data/360_Visualizer_and_Galleries/a45/media/gallery1/standard/2.jpg?w=500"));
			repository.save(new Car("Porsche", "2015","https://upload.wikimedia.org/wikipedia/commons/thumb/a/a5/Porsche_Panamera_4_E-Hybrid_%28MSP17%29.jpg/1200px-Porsche_Panamera_4_E-Hybrid_%28MSP17%29.jpg"));
			repository.save(new Car("BMW", "2013", "https://www.brianjesselbmw.com/Resources/0/images/cars-png/bmw/4-series-2018/front/4-series-1.png"));
		};
	}

	@Bean
	@Scope("singleton")
	public DataProvider vaadinGridDataProvider() {
		return    DataProvider.fromCallbacks((CallbackDataProvider.FetchCallback<Car, Void>) query -> repository.findAll().stream(),
				(CallbackDataProvider.CountCallback<Car, Void>) query -> Integer.valueOf(String.valueOf(repository.count())));
	}
}
