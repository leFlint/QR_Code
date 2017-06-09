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

	/**
	 *controller partie front qui permet a l'utilisateur de voir le service
	 * @param id
	 * @return
	 */
	@GetMapping(URL.COMPTEUR_DE_LIKES_VIEW_URL)
	public ModelAndView compteurDeLikeView(@PathVariable Integer id) {
		ModelAndView mav = new ModelAndView(Pages.COMPTEUR_DE_LIKES_VIEW_PAGE);
		mav.getModel().put("compteurDeLike", repository.find(CompteurDeLike.class, id));
		return mav;
	}

	/**
	 *controller partie front qui permet a l'utilisateur d'utiliser le service
	 * @param id
	 * @return
	 */
	@PostMapping(URL.COMPTEUR_DE_LIKES_DO_LIKE_URL)
	@ResponseBody
	public Integer compteurDeLikeLike(@PathVariable Integer id) {
		return repository.doLikeASentence(id).getNbLike();
	}
}
