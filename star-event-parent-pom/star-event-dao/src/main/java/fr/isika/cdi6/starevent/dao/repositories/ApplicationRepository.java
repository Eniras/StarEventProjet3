package fr.isika.cdi6.starevent.dao.repositories;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

//@Stateless
//@LocalBean
public class ApplicationRepository {

	private static final Logger LOGGER = Logger.getLogger(ApplicationRepository.class.getSimpleName());

	//@PersistenceContext(name = "star-event-ds")
	private EntityManager entityManager;

	public ApplicationRepository() {
	}

//	@PostConstruct
	public void after() {
	}

	/**
	 * Sauvegarde l'entité indiquée en entrée.
	 * 
	 * @param entity Entité à sauvegarder.
	 * @return {@link Optional} de l'identifiant de l'entité après sauvegarde,
	 *         <b>s'il existe => sauvegarde sans erreurs</b>
	 */
//	public Optional<String> sauvegarder(Application entity) {
//		LOGGER.info("Before persisting Application entity with id : " + entity.getId());
//		entityManager.persist(entity);
//		entityManager.flush();
//		LOGGER.info("Persisted Application entity with id : " + entity.getId());
//		return Optional.ofNullable(entity.getId());
//	}

	/**
	 * Met à jour l'entité indiquée en entrée.
	 * 
	 * @param entity Entité à mettre à jour.
	 * @return {@link Optional} de l'identifiant de l'entité modifiée, <b>si la mise
	 *         à jour s'est bien déroulée</b>.
	 */
//	public Optional<String> modifier(Application entity) {
//		LOGGER.info(MessageFormat.format("Before merging {0} with id {1}", entity, entity.getId()));
//		Application newEntity = entityManager.merge(entity);
//		LOGGER.info(MessageFormat.format("After merging {0} with id {1}", entity, entity.getId()));
//		return Optional.ofNullable(newEntity.getId());
//	}

	/**
	 * Suopprime l'entité indiquée par son id.
	 * 
	 * @param entityId
	 * @return
	 */
//	public boolean supprimer(String entityId) {
//		Optional<Application> entity = rechercheParId(entityId);
//		if (entity.isPresent()) {
//			LOGGER.info(MessageFormat.format("Before removing {0} with id {1}", entity, entityId));
//			entityManager.remove(entity);
//			return true;
//		}
//		return false;
//	}

	/**
	 * Recherche l'entité identifiée par l'id indiqué en entrée.
	 * 
	 * @param entityId Identifiant de l'entité à chercher.
	 * @return {@link Optional} de l'entité à rechercher, <b>si elle existe en
	 *         base</b>.
	 */
//	public Optional<Application> rechercheParId(String entityId) {
//		TypedQuery<Application> typedQuery = entityManager
//				.createNamedQuery("SELECT app FROM Application app where app.id=:entityId", Application.class)
//				.setParameter("entityId", entityId);
//		return Optional.ofNullable(typedQuery.getSingleResult());
//	}

	/**
	 * Renvoie une liste de toutes les entités.
	 * 
	 * @return Liste de entités si elles existent, <b>liste vide sinon</b>.
	 */
//	public List<Application> rechercherToutesLesEntites() {
//		TypedQuery<Application> typedQuery = entityManager.createNamedQuery("SELECT app FROM Application",
//				Application.class);
//		return typedQuery.getResultList();
//	}
}
