package com.abitofcode.carrent;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController("/rent")
@AllArgsConstructor
public class RentController {

	@GetMapping
	public ResponseEntity<Rent> getRent(@RequestParam("id") String rentId) {
		Rent rent = rentService.getRent(rentId);
		return rent != null ?
				ResponseEntity.status(HttpStatus.OK).body(rent) :
				ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	private RentService rentService;

}
