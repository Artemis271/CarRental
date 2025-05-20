package com.Artemis;

import com.Artemis.controllers.AdminController;
import com.Artemis.dtos.CarDto;
import com.Artemis.services.admin.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@WebMvcTest(AdminController.class)
@AutoConfigureMockMvc(addFilters = false)
class AdminControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AdminService adminService;

    @Test
    void testGetAllCars() throws Exception {
        List<CarDto> cars = List.of(new CarDto());
        when(adminService.getAllCars()).thenReturn(cars);

        mockMvc.perform(get("/api/admin/cars"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    void testDeleteCar() throws Exception {
        mockMvc.perform(delete("/api/admin/car/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    void testGetCarById_Found() throws Exception {
        CarDto carDto = new CarDto();
        when(adminService.getCarById(1L)).thenReturn(carDto);

        mockMvc.perform(get("/api/admin/car/1"))
                .andExpect(status().isOk());
    }


    @Test
    void testGetBookings() throws Exception {
        when(adminService.getBookings()).thenReturn(List.of());

        mockMvc.perform(get("/api/admin/car/bookings"))
                .andExpect(status().isOk());
    }

    @Test
    void testChangeBookingStatus_Success() throws Exception {
        when(adminService.changeBookingStatus(1L, "APPROVED")).thenReturn(true);

        mockMvc.perform(get("/api/admin/car/booking/1/APPROVED"))
                .andExpect(status().isOk());
    }


}

