package com.honsoft.controller;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.honsoft.service.ArticleService;
import com.honsoft.service.BoardService;

import com.honsoft.entity.Article;

@Controller
@RequestMapping("/")
public class MainController {
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private ArticleService articleService;
	
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
	
	@GetMapping("/boards")
	public String board(Model model,Pageable pageable) {
		model.addAttribute("datetime", new Date());
        model.addAttribute("username", "Ömerrrr");
        model.addAttribute("boardList", boardService.getAllBoards(pageable));
        
		return "board";
	}
	
	 @RequestMapping(value = "/articles/page/{page}")
	    public String listArticlesPageByPage(@PathVariable("page") int page, Model m) {
	        //ModelAndView modelAndView = new ModelAndView("article-list-paging");
	        PageRequest pageable = PageRequest.of(page - 1, 15);
	        Page<Article> articlePage = articleService.getPaginatedArticles(pageable);
	        int totalPages = articlePage.getTotalPages();
	        if(totalPages > 0) {
	            List<Integer> pageNumbers = IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
	            m.addAttribute("pageNumbers", pageNumbers);
	        }
	        m.addAttribute("activeArticleList", true);
	        m.addAttribute("articleList", articlePage.getContent());
	        return "article";
	    }
	 @RequestMapping("/lang")
	    public String lang(Map<String, Object> model) {
	        return "lang";
	    }
}
