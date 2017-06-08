package epsi.lille.project.controller.service;

import org.springframework.beans.factory.annotation.Autowired;

import epsi.lille.project.repo.Repo;

public abstract class AbstractServiceController {
	@Autowired
	protected Repo repo;
}
