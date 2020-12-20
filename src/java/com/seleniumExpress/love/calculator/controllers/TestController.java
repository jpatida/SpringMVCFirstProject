package com.seleniumExpress.love.calculator.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class TestController {

	@ResponseBody
	@RequestMapping("/sayHelloTest")
	public void sayHello() {
		System.out.println("Hi Richi");
	}

}
