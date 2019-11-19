package com.example.demo.web.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@ControllerAdvice
@RestController
@RequestMapping("/login")
public class LoginController {
	
}
