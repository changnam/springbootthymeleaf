package com.honsoft.controller;

import java.security.Principal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/")
public class MainController {
	//private String appMode;

    //@Autowired
    //public MainController(Environment environment){
    //   appMode = environment.getProperty("app-mode");
    //}
    
	/*
	 * @GetMapping("/") public String home() {
	 * System.out.println(Thread.currentThread() + " writes: ");
	 * System.out.println("*****************************************************");
	 * Thread.getAllStackTraces().keySet().forEach( (t) ->
	 * System.out.println(t.getName() + "Is Daemon " + t.isDaemon() + "Is Alive " +
	 * t.isAlive()));
	 * 
	 * return "main"; }
	 */
	
	@GetMapping("/layout")
	public String layout() {
		return "layout";
	}
	
	/*
	 * @RequestMapping(value = "/", method = RequestMethod.GET) public String
	 * index(Principal principal) { return principal != null ? "home/homeSignedIn" :
	 * "home/homeNotSignedIn"; }
	 */
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("datetime", new Date());
        model.addAttribute("username", "Ömerrrr");
        model.addAttribute("template", "test");
        
		return "index";
	}
	
	@GetMapping("/main")
	public String main(Model model) {
		model.addAttribute("datetime", new Date());
        model.addAttribute("username", "Ömerrrr");
        //model.addAttribute("mode", appMode);
        
		return "main";
	}
	
	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("datetime", new Date());
        model.addAttribute("username", "Ömerrrr");
        //model.addAttribute("mode", appMode);
        
		return "home";
	}
	
	@GetMapping("/about")
	public String about(Model model) {
		model.addAttribute("datetime", new Date());
        model.addAttribute("username", "Ömerrrr");
        //model.addAttribute("mode", appMode);
        
		return "about";
	}
	
	@GetMapping("/content")
	public String content(Model model) {
		model.addAttribute("datetime", new Date());
        model.addAttribute("username", "Ömerrrr");
        //model.addAttribute("mode", appMode);
        
		return "content";
	}
}
