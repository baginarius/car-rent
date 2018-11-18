package com.abitofcode.carrent;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@RunWith(SpringRunner.class)
@WebMvcTest(RentController.class)
public class RentControllerTest {

	@Test
	public void shouldGetRentById() throws Exception {
		//given
		Mockito.when(rentService.getRent("1"))
				.thenReturn(
						Rent.builder().carNo(CAR_NO).build());

		//when
		ResultActions resultActions = mockMvc.perform(
				get("/rent").param("id", "1"));

		//then
		resultActions.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString(CAR_NO)));
	}

	@Test
	public void shouldHandleInvalidId() throws Exception {
		//given

		//when
		ResultActions resultActions = mockMvc.perform(
				get("/rent").param("id", "1"));

		//then
		resultActions.andDo(print())
				.andExpect(status().isNotFound())
				.andExpect(content().string(""));
	}

	private static final String CAR_NO = "123456790";

	@MockBean
	private RentService rentService;

	@Autowired
	private MockMvc mockMvc;

}