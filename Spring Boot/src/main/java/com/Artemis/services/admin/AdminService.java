package com.Artemis.services.admin;

import com.Artemis.dtos.BookACarDto;
import com.Artemis.dtos.CarDto;
import com.Artemis.dtos.CarDtoList;
import com.Artemis.dtos.SearchCarDto;

import java.io.IOException;
import java.util.List;

public interface AdminService {

    boolean postCar(CarDto carDto);

    List<CarDto> getAllCars();

    void deleteCar(Long carId);

    CarDto getCarById(Long cardId);

    boolean updateCar(Long carId,CarDto carDto) throws IOException;

    List<BookACarDto> getBookings();

    boolean changeBookingStatus(Long bookingId, String status);

    CarDtoList searchCar(SearchCarDto searchCarDto);

}
