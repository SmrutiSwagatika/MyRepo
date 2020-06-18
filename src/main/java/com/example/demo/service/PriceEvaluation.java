package com.example.demo.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.demo.pojo.ChainAssembly;
import com.example.demo.pojo.Frame;
import com.example.demo.pojo.HandleBarWithBrakes;
import com.example.demo.pojo.Seating;
import com.example.demo.pojo.Wheels;
import com.example.demo.runner.DataInputService;

@Component
public class PriceEvaluation implements Runnable, ApplicationRunner {
	@Autowired
	Frame frame;
	@Autowired
	ChainAssembly chainAssembly;
	@Autowired
	HandleBarWithBrakes handleBarWithBrakes;
	@Autowired
	Seating seating;
	@Autowired
	Wheels wheels;
	public static BlockingQueue<Map<Object, Double>> queue = new ArrayBlockingQueue<>(10);;
	Map<String, Object> cycleModel;

	@Override
	public void run() {
		try {
			cycleModel = DataInputService.cycleModel;
			Set s = cycleModel.entrySet();
			Iterator i = s.iterator();
			while (i.hasNext()) {
				Map.Entry entry = (Entry) i.next();
				Double value = price(entry.getValue());
				Map<Object, Double> map = new HashMap<>();
				map.put(entry.getValue(), value);
				queue.put(map);
				Thread.sleep(1000);
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

	}

	public double price(Object obj) {
		// TODO Auto-generated method stub
		String value = obj.toString();
		String actualValue = value.substring(1, value.indexOf("}"));
		String[] values = actualValue.split(",");
		double price = 0.0;
		for (String val : values) {
			String key = val.split("=")[0].trim();
			String va = val.split("=")[1].trim();
			if (key.equalsIgnoreCase("frame")) {
				price = price + frame.getPrice(va);
			}
			if (key.equalsIgnoreCase("ChainAssembly")) {
				price = price + chainAssembly.getPrice(va);
			}
			if (key.equalsIgnoreCase("HandleBarWithBrakes")) {
				price = price + handleBarWithBrakes.getPrice(va);
			}
			if (key.equalsIgnoreCase("Seating")) {
				price = price + seating.getPrice(va);
			}
			if (key.equalsIgnoreCase("Wheels")) {
				price = price + wheels.getPrice(va);
			}
		}
		return price;
	}
}
