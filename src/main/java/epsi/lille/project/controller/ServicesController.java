package epsi.lille.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import epsi.lille.project.model.Redirection;
import epsi.lille.project.repo.Repo;

@Controller
public class ServicesController {

	@Autowired
	Repo repo;

	@PostMapping("/redirections")
	@ResponseBody
	private Redirection redirectionPost(@RequestBody Redirection redirection) {
		repo.save(redirection);
		return redirection;
	}

	@GetMapping("/redirections")
	private ModelAndView redirections() {
		ModelAndView mav = new ModelAndView("service/redirection/index");
		return mav;
	}

	@GetMapping("/redirections/list")
	private ModelAndView redirectionsList() {
		ModelAndView mav = new ModelAndView("service/redirection/list");
		mav.getModel().put("redirections", repo.findAll(Redirection.class));
		return mav;
	}

	@GetMapping("/redirections/form")
	private String redirectionsForm() {
		return "service/redirection/form";
	}

	@GetMapping("/redirections/view/{id}")
	private ModelAndView redirectionsView(@PathVariable Integer id) {
		ModelAndView mav = new ModelAndView("service/redirection/view");
		mav.getModel().put("redirection", repo.find(Redirection.class, id));
		return mav;
	}

	@GetMapping("/compteurDeLike")
	private ModelAndView compteurDeLike() {
		ModelAndView mav = new ModelAndView("service/compteurDeLike/index");
		return mav;
	}
}
