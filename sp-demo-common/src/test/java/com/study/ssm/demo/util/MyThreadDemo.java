package com.study.ssm.demo.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThreadDemo {

	public static void main(String[] args) {
		Executors.newCachedThreadPool();
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(15);
		Executors.newSingleThreadExecutor();
	}
}
