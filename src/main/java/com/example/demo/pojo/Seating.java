package com.example.demo.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Seating {
	@Value("${SeatingType1}")
	private double SeatingType1;
	@Value("${SeatingType2}")
	private double SeatingType2;
	@Value("${SeatingType3}")
	private double SeatingType3;

	public double getSeatingType1() {
		return SeatingType1;
	}

	public void setSeatingType1(double seatingType1) {
		SeatingType1 = seatingType1;
	}

	public double getSeatingType2() {
		return SeatingType2;
	}

	public void setSeatingType2(double seatingType2) {
		SeatingType2 = seatingType2;
	}

	public double getSeatingType3() {
		return SeatingType3;
	}

	public void setSeatingType3(double seatingType3) {
		SeatingType3 = seatingType3;
	}
	public double getPrice(String value) {
		if (value.equalsIgnoreCase("SeatingType1"))
			return getSeatingType1();
		else if (value.equalsIgnoreCase("SeatingType2"))
			return getSeatingType2();
		else if (value.equalsIgnoreCase("SeatingType3"))
			return getSeatingType3();
		return 0;

	}
}
