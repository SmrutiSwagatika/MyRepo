package com.example.demo.service;

import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.springframework.stereotype.Component;

@Component
public class PriceDisplay implements Runnable {
	BlockingQueue que = PriceEvaluation.queue;
	BlockingQueue queue = new ArrayBlockingQueue<>(10);
	Map<String, Object> cycleModel;

	@Override
	public void run() {
		while (true) {
			try {
				System.out.println(que.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
