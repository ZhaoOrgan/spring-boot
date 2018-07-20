package com.springboot.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaoxuefeng
 *
 */
@RestController
@RequestMapping(value = "/index")
public class IndexController {

	@RequestMapping
	public String index() {
		return "StringBoot～～～";
	}

	@RequestMapping(value = "/get_session", method = RequestMethod.GET)
	public Object getSession(HttpServletRequest request) {
		return "sessionId:" + request.getSession().getId();
	}
}
