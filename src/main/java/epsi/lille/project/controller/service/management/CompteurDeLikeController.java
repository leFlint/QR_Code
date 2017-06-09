package epsi.lille.project.controller.service.management;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import epsi.lille.project.ProjectApplication;
import epsi.lille.project.controller.service.AbstractServiceController;
import epsi.lille.project.controller.service.constantes.Pages;
import epsi.lille.project.controller.service.constantes.URL;
import epsi.lille.project.model.CompteurDeLike;

@Controller
@PreAuthorize("hasRole('" + ProjectApplication.SERVICE_CREATOR_ROLE + "')")
public class CompteurDeLikeController extends AbstractServiceController {

	/**
	 *cree un service compteur de like
	 * @param compteurDeLike
	 * @return
	 */
	@PostMapping(URL.COMPTEUR_DE_LIKES_MANAGEMENT_ROOT)
	@ResponseBody
	public CompteurDeLike compteurDeLikePost(@RequestBody CompteurDeLike compteurDeLike) {
		repository.save(compteurDeLike);
		return compteurDeLike;
	}

	/**
	 *acceder à la page d'index du service Compteur de Like
	 * @return
	 */
	@GetMapping(URL.COMPTEUR_DE_LIKES_MANAGEMENT_ROOT)
	public ModelAndView compteurDeLike() {
		ModelAndView mav = new ModelAndView(Pages.COMPTEUR_DE_LIKES_INDEX_PAGE);
		return mav;
	}

	/**
	 *acceder a la liste des compteur créées
	 * @return
	 */
	@GetMapping(URL.COMPTEUR_DE_LIKES_LIST)
	public ModelAndView compteurDeLikeList() {
		ModelAndView mav = new ModelAndView(Pages.COMPTEUR_DE_LIKES_LIST_PAGE);
		mav.getModel().put("compteurDeLikes", repository.findAll(CompteurDeLike.class));
		return mav;
	}

	/**
	 *acceder au formulaire de creation compteur de like
	 * @return
	 */
	@GetMapping(URL.COMPTEUR_DE_LIKES_CREATE)
	public String compteurDeLikeForm() {
		return Pages.COMPTEUR_DE_LIKES_CREATE_PAGE;
	}
}