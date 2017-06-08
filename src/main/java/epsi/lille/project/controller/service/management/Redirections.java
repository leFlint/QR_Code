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
import epsi.lille.project.model.Redirection;

@Controller
public class Redirections extends AbstractServiceController {

	@PostMapping(URL.REDIRECTIONS_MANAGEMENT_ROOT)
	@ResponseBody
	Redirection redirectionPost(@RequestBody Redirection redirection) {
		repo.save(redirection);
		return redirection;
	}

	@GetMapping(URL.REDIRECTIONS_MANAGEMENT_ROOT)
	ModelAndView redirections() {
		ModelAndView mav = new ModelAndView(Pages.REDIRECTIONS_INDEX_PAGE);
		return mav;
	}

	@GetMapping(URL.REDIRECTIONS_LIST)
	ModelAndView redirectionsList() {
		ModelAndView mav = new ModelAndView(Pages.REDIRECTIONS_LIST_PAGE);
		mav.getModel().put("redirections", repo.findAll(Redirection.class));
		return mav;
	}

	@GetMapping(URL.REDIRECTIONS_CREATE)
	String redirectionsForm() {
		return Pages.REDIRECTIONS_CREATE_PAGE;
	}
}