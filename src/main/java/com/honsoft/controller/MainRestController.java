package com.honsoft.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MainRestController {
	@GetMapping("/")
	public String home() {
		System.out.println(Thread.currentThread() + " writes: ");
		System.out.println("*****************************************************");
		Thread.getAllStackTraces().keySet().forEach(
				(t) -> System.out.println(t.getName() + "Is Daemon " + t.isDaemon() + "Is Alive " + t.isAlive()));

		return "this is main home";
	}
	
	@GetMapping("/layout")
	public String layout() {
		return "layout";
	}
}
