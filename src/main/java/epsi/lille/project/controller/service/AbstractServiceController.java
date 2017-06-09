package epsi.lille.project.controller.service;

import epsi.lille.project.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;



public abstract class AbstractServiceController {
	@Autowired
	protected Repository repository;
}
