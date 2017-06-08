package epsi.lille.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import epsi.lille.project.model.CompteurDeLike;
import epsi.lille.project.model.Redirection;
import epsi.lille.project.repo.Repo;

@Controller
public class ServicesController {

	@Autowired
	Repo repo;

	/*
	 * Mapping pour le service Redirection
	 */
	@PostMapping("/redirections")
	@ResponseBody
	Redirection redirectionPost(@RequestBody Redirection redirection) {
		repo.save(redirection);
		return redirection;
	}

	@GetMapping("/redirections")
	ModelAndView redirections() {
		ModelAndView mav = new ModelAndView("service/redirection/index");
		return mav;
	}

	@GetMapping("/redirections/list")
	ModelAndView redirectionsList() {
		ModelAndView mav = new ModelAndView("service/redirection/list");
		mav.getModel().put("redirections", repo.findAll(Redirection.class));
		return mav;
	}

	@GetMapping("/redirections/form")
	String redirectionsForm() {
		return "service/redirection/form";
	}

	@GetMapping("/redirections/view/{id}")
	ModelAndView redirectionsView(@PathVariable Integer id) {
		ModelAndView mav = new ModelAndView("service/redirection/view");
		mav.getModel().put("redirection", repo.find(Redirection.class, id));
		return mav;
	}

	/*
	 * Mapping pour le service Compteur de Like
	 */
	@PostMapping("/compteurDeLike")
	@ResponseBody
	CompteurDeLike redirectionPost(@RequestBody CompteurDeLike compteurDeLike) {
		repo.save(compteurDeLike);
		return compteurDeLike;
	}

	@GetMapping("/compteurDeLike")
	ModelAndView compteurDeLike() {
		ModelAndView mav = new ModelAndView("service/compteurDeLike/index");
		return mav;
	}

	@GetMapping("/compteurDeLike/list")
	ModelAndView compteurDeLikeList() {
		ModelAndView mav = new ModelAndView("service/compteurDeLike/list");
		mav.getModel().put("compteurDeLikes", repo.findAll(CompteurDeLike.class));
		return mav;
	}

	@GetMapping("/compteurDeLike/form")
	String compteurDeLikeForm() {
		return "service/compteurDeLike/form";
	}

	@GetMapping("/compteurDeLike/view/{id}")
	ModelAndView compteurDeLikeView(@PathVariable Integer id) {
		ModelAndView mav = new ModelAndView("service/compteurDeLike/view");
		mav.getModel().put("compteurDeLike", repo.find(CompteurDeLike.class, id));
		return mav;
	}
	
	@PostMapping("/compteurDeLike/like/{id}")
	@ResponseBody
	Integer compteurDeLikeLike(@PathVariable Integer id) {
		return repo.doLikeASentence(id).getNbLike();
	}
}
