package com.springkafka.boot.mvc.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springkafka.boot.mvc.model.Message;

@Controller
public class MainController {
	
	private static Logger logger = Logger.getLogger(MainController.class);

	@RequestMapping(value={"/"}, method = RequestMethod.GET)
	public ModelAndView defaultView() {
		ModelAndView md = new ModelAndView();
		System.out.println("Default view");
		logger.debug("Default View");
		md.addObject("msg", "Hello!!");
		md.setViewName("index");
		return md;
	}
	
	@RequestMapping(value= {"/sendMessage"}, method = RequestMethod.POST)
	public ModelAndView sendMessageView(Message message) {
		System.out.println(message);
		logger.debug(message.msg);
		ModelAndView md = new ModelAndView();
		
		md.addObject("msg", message.msg);
		md.setViewName("index");
		return md;
	}
	
	@RequestMapping(value={"/error2"}, method = RequestMethod.GET)
	public ModelAndView errorView() {
		ModelAndView md = new ModelAndView();
		md.addObject("err", "error");
		return md;
	}
	
}
