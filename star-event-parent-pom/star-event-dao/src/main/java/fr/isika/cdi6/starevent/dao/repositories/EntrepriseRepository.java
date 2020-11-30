package fr.isika.cdi6.starevent.dao.repositories;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cdi6.starevent.data.model.gestion.Entreprise;
import fr.isika.cdi6.starevent.data.model.gestion.Partenaire;
@Stateless
public class EntrepriseRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public EntrepriseRepository() {
	}

	public List<Entreprise> findAll() {
		return entityManager.createNamedQuery("Entreprise.findAll", Entreprise.class).getResultList();
	}

	public void create(Entreprise entreprise, Integer idPartenaire) {
		this.entityManager.persist(entreprise);

		Partenaire p = this.entityManager.find(Partenaire.class, idPartenaire);

		p.setEntreprise(entreprise);

		this.entityManager.merge(p);
		this.entityManager.flush();

	}

	public void update(Entreprise entreprise) {
		this.entityManager.merge(entreprise);
	}

	public void remove(Integer idEntreprise) {
		this.entityManager.remove(this.findById(idEntreprise));
	}

	public Entreprise findById(Integer idEntreprise) {
		return entityManager.find(Entreprise.class, idEntreprise);
	}

}