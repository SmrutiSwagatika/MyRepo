package com.example.demo.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Frame {
	@Value("${FrameType1}")
	private double FrameType1;
	@Value("${FrameType2}")
	private double FrameType2;
	@Value("${FrameType3}")
	private double FrameType3;

	public double getFrameType1() {
		return FrameType1;
	}

	public void setFrameType1(double frameType1) {
		FrameType1 = frameType1;
	}

	public double getFrameType2() {
		return FrameType2;
	}

	public void setFrameType2(double frameType2) {
		FrameType2 = frameType2;
	}

	public double getFrameType3() {
		return FrameType3;
	}

	public void setFrameType3(double frameType3) {
		FrameType3 = frameType3;
	}
	public double getPrice(String value) {
		if (value.equalsIgnoreCase("FrameType1"))
			return getFrameType1();
		else if (value.equalsIgnoreCase("FrameType2"))
			return getFrameType2();
		else if (value.equalsIgnoreCase("FrameType3"))
			return getFrameType3();
		return 0;

	}
}
