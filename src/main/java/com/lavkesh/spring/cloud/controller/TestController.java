package com.lavkesh.spring.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class TestController {
	
	@Autowired
	Environment env;
	
	@RequestMapping("/test")
	String getTestParam() {
		String testMessage = env.getProperty("test");
		String host = env.getProperty("datasurces.readDataSource.host");
		return "{testMessage: "+testMessage + ", host: "+host+"}";
	}

}
