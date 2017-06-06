package epsi.lille.project.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class Repo {

	@Autowired
	EntityManager em;

	public void save(Object obj) {
		em.persist(obj);
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> findAll(Class<T> clazz) {
		return em.createQuery("Select t from " + clazz.getSimpleName() + " t")
				.getResultList();
	}

	public <T> T find(Class<T> clazz, Integer id) {
		return em.find(clazz, id);
	}

}
