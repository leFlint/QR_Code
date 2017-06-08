package epsi.lille.project.controller.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import epsi.lille.project.controller.service.constantes.Pages;
import epsi.lille.project.controller.service.constantes.URL;
import epsi.lille.project.model.Redirection;

@Controller
public class RedirectionServiceController extends AbstractServiceController {

	@GetMapping(URL.REDIRECTIONS_VIEW_URL)
	ModelAndView redirectionsView(@PathVariable Integer id) {
		ModelAndView mav = new ModelAndView(Pages.REDIRECTIONS_VIEW_PAGE);
		mav.getModel().put("redirection", repo.find(Redirection.class, id));
		return mav;
	}
}
