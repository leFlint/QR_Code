package epsi.lille.project.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import epsi.lille.project.model.CompteurDeLike;

/**
 * Service d'accès aux données via hibernate
 */
@Service
@Transactional
public class Repository {

	@Autowired
	EntityManager em;

	/**
	 * fonction de sauvegarde
	 * @param obj
	 */
	public void save(Object obj) {
		em.persist(obj);
	}

	@SuppressWarnings("unchecked")
	/**
	 * fonction de liste
	 */
	public <T> List<T> findAll(Class<T> clazz) {
		return em.createQuery("Select t from " + clazz.getSimpleName() + " t").getResultList();
	}

	/**
	 * fonction de recuperation d'une seule donnée
	 * @param clazz
	 * @param id
	 * @param <T>
	 * @return
	 */
	public <T> T find(Class<T> clazz, Integer id) {
		return em.find(clazz, id);
	}

	/**
	 * ajoute un like a la phrase
	 * @param id
	 * @return
	 */
	public CompteurDeLike doLikeASentence(Integer id) {
		CompteurDeLike compteur = find(CompteurDeLike.class, id);
		compteur.setNbLike(compteur.getNbLike() + 1);
		em.merge(compteur);
		return compteur;
	}

}