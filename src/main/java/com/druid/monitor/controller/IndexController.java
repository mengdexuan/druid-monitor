package com.druid.monitor.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/index")
@Slf4j
public class IndexController {


	@Autowired
	JdbcTemplate jdbcTemplate;


	@RequestMapping("/test")
	public String index(HttpServletRequest request){

		log.info("线程名称："+Thread.currentThread().getName());

//		String sql = "select * from test where id = ?";
//		List<Map<String, Object>> mapList = jdbcTemplate.queryForList(sql,1);

		return "index";
	}


	@RequestMapping("/test2")
	public String index2( ){

		String sql = "insert into test(id) values (?)";

		jdbcTemplate.update(sql,"ddd");

		return "index";
	}


	@RequestMapping("/test3")
	public String index3( ){

		String sql = "delete from test where info_id = ?";

		jdbcTemplate.update(sql,15);

		return "index";
	}


}



















