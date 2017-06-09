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
import epsi.lille.project.model.Redirection;

@Controller
@PreAuthorize("hasRole('" + ProjectApplication.SERVICE_CREATOR_ROLE + "')")
public class Redirections extends AbstractServiceController {

	/**
	 *crée le service de redirection
	 * @param redirection
	 * @return
	 */
	@PostMapping(URL.REDIRECTIONS_MANAGEMENT_ROOT)
	@ResponseBody
	Redirection redirectionPost(@RequestBody Redirection redirection) {
		repository.save(redirection);
		return redirection;
	}

	/**
	 *acceder à la page d'index du service redirections
	 * @return
	 */
	@GetMapping(URL.REDIRECTIONS_MANAGEMENT_ROOT)
	ModelAndView redirections() {
		ModelAndView mav = new ModelAndView(Pages.REDIRECTIONS_INDEX_PAGE);
		return mav;
	}

	/**
	 *accede a la liste de redirections
	 * @return
	 */
	@GetMapping(URL.REDIRECTIONS_LIST)
	ModelAndView redirectionsList() {
		ModelAndView mav = new ModelAndView(Pages.REDIRECTIONS_LIST_PAGE);
		mav.getModel().put("redirections", repository.findAll(Redirection.class));
		return mav;
	}

	/**
	 *permet d'acceder au formulaire de creation
	 * @return
	 */
	@GetMapping(URL.REDIRECTIONS_CREATE)
	String redirectionsForm() {
		return Pages.REDIRECTIONS_CREATE_PAGE;
	}
}