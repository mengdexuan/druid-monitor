package com.druid.monitor.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author mengdexuan on 2018/11/16 15:37.
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

	@Autowired
	ServerProperties serverProperties;


	@RequestMapping("/test1")
	public Object test1(HttpServletRequest request){
		Object obj = new Object();


		obj = serverProperties;




		return obj;
	}


	@RequestMapping("/test2")
	public Object test2(HttpServletRequest request){
		Object obj = new Object();


		return obj;
	}


	@RequestMapping("/test3")
	public Object test3(HttpServletRequest request){
		Object obj = new Object();


		return obj;
	}

}
