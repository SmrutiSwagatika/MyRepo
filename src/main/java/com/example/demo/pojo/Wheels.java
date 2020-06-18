package com.example.demo.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Wheels {
	@Value("${WheelsType1}")
	private double WheelsType1;
	@Value("${WheelsType2}")
	private double WheelsType2;
	@Value("${WheelsType3}")
	private double WheelsType3;

	public double getWheelsType1() {
		return WheelsType1;
	}

	public void setWheelsType1(double wheelsType1) {
		WheelsType1 = wheelsType1;
	}

	public double getWheelsType2() {
		return WheelsType2;
	}

	public void setWheelsType2(double wheelsType2) {
		WheelsType2 = wheelsType2;
	}

	public double getWheelsType3() {
		return WheelsType3;
	}

	public void setWheelsType3(double wheelsType3) {
		WheelsType3 = wheelsType3;
	}

	public double getPrice(String value) {
		if (value.equalsIgnoreCase("WheelsType1"))
			return getWheelsType1();
		else if (value.equalsIgnoreCase("WheelsType2"))
			return getWheelsType2();
		else if (value.equalsIgnoreCase("WheelsType3"))
			return getWheelsType3();
		return 0;

	}

}
