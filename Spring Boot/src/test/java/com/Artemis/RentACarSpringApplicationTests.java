package com.Artemis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class RentACarSpringApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	@Test
	public void postCar() throws Exception {
		mockMvc.perform(post("/api/admin/car")
						.param("id", "0")
						.param("name", "")
						.param("color", "")
						.param("transmission", "")
						.param("brand", "")
						.param("type", "")
						.param("modelYear", "")
						.param("description", "")
						.param("price", "0")
						.param("image", "")
						.param("returnedImage", "")
						.with(SecurityMockMvcRequestPostProcessors.csrf())
						.with(SecurityMockMvcRequestPostProcessors.user("user")))
				.andExpect(status().isOk())
				.andDo(print());
	}

	@Test
	public void getAllCars() throws Exception {
		mockMvc.perform(get("/api/admin/cars")
						.with(SecurityMockMvcRequestPostProcessors.csrf())
						.with(SecurityMockMvcRequestPostProcessors.user("user")))
				.andExpect(status().isOk())
				.andDo(print());
	}

	@Test
	public void deleteCar() throws Exception {
		mockMvc.perform(delete("/api/admin/car/{0}", "0")
						.with(SecurityMockMvcRequestPostProcessors.csrf())
						.with(SecurityMockMvcRequestPostProcessors.user("user")))
				.andExpect(status().isOk())
				.andDo(print());
	}

	@Test
	public void getCarById() throws Exception {
		mockMvc.perform(get("/api/admin/car/{0}", "0")
						.with(SecurityMockMvcRequestPostProcessors.csrf())
						.with(SecurityMockMvcRequestPostProcessors.user("user")))
				.andExpect(status().isOk())
				.andDo(print());
	}

	@Test
	public void updateCar() throws Exception {
		mockMvc.perform(put("/api/admin/car/{0}", "0")
						.param("id", "0")
						.param("name", "")
						.param("color", "")
						.param("transmission", "")
						.param("brand", "")
						.param("type", "")
						.param("modelYear", "")
						.param("description", "")
						.param("price", "0")
						.param("image", "")
						.param("returnedImage", "")
						.with(SecurityMockMvcRequestPostProcessors.csrf())
						.with(SecurityMockMvcRequestPostProcessors.user("user")))
				.andExpect(status().isOk())
				.andDo(print());
	}

	@Test
	public void getBookings() throws Exception {
		mockMvc.perform(get("/api/admin/car/bookings")
						.with(SecurityMockMvcRequestPostProcessors.csrf())
						.with(SecurityMockMvcRequestPostProcessors.user("user")))
				.andExpect(status().isOk())
				.andDo(print());
	}

	@Test
	public void changeBookingStatus() throws Exception {
		mockMvc.perform(get("/api/admin/car/booking/{0}/{1}", "0", "")
						.with(SecurityMockMvcRequestPostProcessors.csrf())
						.with(SecurityMockMvcRequestPostProcessors.user("user")))
				.andExpect(status().isOk())
				.andDo(print());
	}

	@Test
	public void searchCar() throws Exception {
		String searchCarDto = """
				{
				    "brand": "",
				    "type": "",
				    "transmission": "",
				    "color": ""
				}""";

		mockMvc.perform(post("/api/admin/car/search")
						.with(SecurityMockMvcRequestPostProcessors.csrf())
						.with(SecurityMockMvcRequestPostProcessors.user("user"))
						.content(searchCarDto)
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andDo(print());
	}
}
