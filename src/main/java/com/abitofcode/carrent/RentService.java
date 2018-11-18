package com.abitofcode.carrent;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class RentService {

	public RentService() {
		RENTS.put("1", Rent.builder().carNo("XYZ123").id(1L).start(new Date()).end(new Date()).build());
	}

	public Rent getRent(String rentId) {
		return RENTS.get(rentId);
	}

	private static final Map<String, Rent> RENTS = new HashMap<>();

}
