package com.Artemis.services.customer;

import com.Artemis.dtos.BookACarDto;
import com.Artemis.dtos.CarDto;
import com.Artemis.dtos.CarDtoList;
import com.Artemis.dtos.SearchCarDto;

import java.util.List;

public interface CustomerService {

    List<CarDto> getAllCars();

    CarDto getCarById(Long carId);

    boolean bookACar(Long carId, BookACarDto bookACarDto);

    List<BookACarDto> getBookingsByUserId(Long userId);

    CarDtoList searchCar(SearchCarDto searchCarDto);

}
