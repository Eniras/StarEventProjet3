package fr.isika.cdi6.starevent.dao.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cdi6.starevent.data.model.gestion.Partenaire;
import fr.isika.cdi6.starevent.data.model.utilisateurs.Client;
import fr.isika.cdi6.starevent.data.model.utilisateurs.Utilisateur;

@Stateless
public class UtilisateurRepository {

	@PersistenceContext
	private EntityManager entityManager;


	public Integer create(Utilisateur utilisateur) {

		this.entityManager.persist(utilisateur);
		this.entityManager.flush();
		return utilisateur.getIdUtilisateur();
	}

	public void update(Utilisateur utilisateur) {
		entityManager.merge(utilisateur);
		this.entityManager.flush();
	}

	public void remove(Integer idUtilisateur) {
		Utilisateur utilisateur = entityManager.find(Utilisateur.class, idUtilisateur);
		entityManager.remove(utilisateur);
		this.entityManager.flush();
	}

	public Utilisateur findById(Integer idUtilisateur) {
		return entityManager.find(Utilisateur.class, idUtilisateur);
	}

	public List<Utilisateur> findAll() {

		return (List<Utilisateur>) entityManager.createNamedQuery("Utilisateur.findAll", Utilisateur.class).getResultList();
	}

}