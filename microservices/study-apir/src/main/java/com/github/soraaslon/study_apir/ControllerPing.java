package com.github.soraaslon.study_apir;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ping")
public class ControllerPing {

	@RequestMapping
	public String ping() {
		return "pong";
	}
}
