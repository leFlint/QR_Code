package epsi.lille.project.controller.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import epsi.lille.project.controller.service.constantes.Pages;
import epsi.lille.project.controller.service.constantes.URL;
import epsi.lille.project.model.CompteurDeLike;

@Controller
public class CompteurDeLikeServiceController extends AbstractServiceController {

	@GetMapping(URL.COMPTEUR_DE_LIKES_VIEW_URL)
	ModelAndView compteurDeLikeView(@PathVariable Integer id) {
		ModelAndView mav = new ModelAndView(Pages.COMPTEUR_DE_LIKES_VIEW_PAGE);
		mav.getModel().put("compteurDeLike", repo.find(CompteurDeLike.class, id));
		return mav;
	}

	@PostMapping(URL.COMPTEUR_DE_LIKES_DO_LIKE_URL)
	@ResponseBody
	Integer compteurDeLikeLike(@PathVariable Integer id) {
		return repo.doLikeASentence(id).getNbLike();
	}
}
