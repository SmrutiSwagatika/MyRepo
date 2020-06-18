package com.example.demo.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HandleBarWithBrakes {
	@Value("${HandleBarWithBrakesType1}")
	private double HandleBarWithBrakesType1;
	@Value("${HandleBarWithBrakesType2}")
	private double HandleBarWithBrakesType2;
	@Value("${HandleBarWithBrakesType3}")
	private double HandleBarWithBrakesType3;

	public double getHandleBarWithBrakesType1() {
		return HandleBarWithBrakesType1;
	}

	public void setHandleBarWithBrakesType1(double handleBarWithBrakesType1) {
		HandleBarWithBrakesType1 = handleBarWithBrakesType1;
	}

	public double getHandleBarWithBrakesType2() {
		return HandleBarWithBrakesType2;
	}

	public void setHandleBarWithBrakesType2(double handleBarWithBrakesType2) {
		HandleBarWithBrakesType2 = handleBarWithBrakesType2;
	}

	public double getHandleBarWithBrakesType3() {
		return HandleBarWithBrakesType3;
	}

	public void setHandleBarWithBrakesType3(double handleBarWithBrakesType3) {
		HandleBarWithBrakesType3 = handleBarWithBrakesType3;
	}
	public double getPrice(String value) {
		if (value.equalsIgnoreCase("HandleBarWithBrakesType1"))
			return getHandleBarWithBrakesType1();
		else if (value.equalsIgnoreCase("HandleBarWithBrakesType2"))
			return getHandleBarWithBrakesType2();
		else if (value.equalsIgnoreCase("HandleBarWithBrakesType3"))
			return getHandleBarWithBrakesType3();
		return 0;

	}
}
