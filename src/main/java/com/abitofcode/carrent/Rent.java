package com.abitofcode.carrent;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rent {

	private Long id;

	private Date start;

	private Date end;

	private String carNo;


}
