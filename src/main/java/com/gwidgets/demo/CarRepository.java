package com.gwidgets.demo;

import com.gwidgets.demo.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, String> { }