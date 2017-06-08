package epsi.lille.project.controller.service.management;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import epsi.lille.project.controller.service.AbstractServiceController;
import epsi.lille.project.controller.service.constantes.Pages;
import epsi.lille.project.controller.service.constantes.URL;
import epsi.lille.project.model.CompteurDeLike;

@Controller
public class CompteurDeLikeController extends AbstractServiceController {

	@PostMapping(URL.COMPTEUR_DE_LIKES_MANAGEMENT_ROOT)
	@ResponseBody
	CompteurDeLike compteurDeLikePost(@RequestBody CompteurDeLike compteurDeLike) {
		repo.save(compteurDeLike);
		return compteurDeLike;
	}

	@GetMapping(URL.COMPTEUR_DE_LIKES_MANAGEMENT_ROOT)
	ModelAndView compteurDeLike() {
		ModelAndView mav = new ModelAndView(Pages.COMPTEUR_DE_LIKES_INDEX_PAGE);
		return mav;
	}

	@GetMapping(URL.COMPTEUR_DE_LIKES_LIST)
	ModelAndView compteurDeLikeList() {
		ModelAndView mav = new ModelAndView(Pages.COMPTEUR_DE_LIKES_LIST_PAGE);
		mav.getModel().put("compteurDeLikes", repo.findAll(CompteurDeLike.class));
		return mav;
	}

	@GetMapping(URL.COMPTEUR_DE_LIKES_CREATE)
	String compteurDeLikeForm() {
		return Pages.COMPTEUR_DE_LIKES_CREATE_PAGE;
	}
}