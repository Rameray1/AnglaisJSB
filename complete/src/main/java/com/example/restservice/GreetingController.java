package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();


//	@GetMapping("/greeting")
//	public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
//		return counter.incrementAndGet()+ " " + String.format(template, name);
//	}

	@GetMapping("/greeting/{name}")
	public String greeting(@PathVariable String name) {
		return counter.incrementAndGet()+ " " + name;
	}


	@PostMapping("/greeting/setProfile")
	public void setProfile(@RequestBody Profile profile){
		System.out.println("Name: " + profile.name);
		System.out.println("Email: " + profile.email);
		System.out.println("Phone: " + profile.phone);
	}



}


class Profile{
	public String name;
	public String email;
	public String phone;

	public Profile(String name, String email, String phone) {
		this.name = name;
		this.email = email;
		this.phone = phone;
	}
}