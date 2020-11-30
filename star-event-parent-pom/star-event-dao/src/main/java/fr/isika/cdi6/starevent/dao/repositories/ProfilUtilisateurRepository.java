package fr.isika.cdi6.starevent.dao.repositories;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cdi6.starevent.data.model.utilisateurs.ProfilUtilisateur;

@Stateless
public class ProfilUtilisateurRepository {	
	
	@PersistenceContext
	private EntityManager entityManager;	
	
	public ProfilUtilisateurRepository() {	}
	
	public List<ProfilUtilisateur> findAll(){
		return entityManager.createNamedQuery("ProfilUtilisateur.findAll", ProfilUtilisateur.class).getResultList();
	}	
	
	
	public void create(ProfilUtilisateur profilUtilisateur) {
		this.entityManager.persist(profilUtilisateur);
	}	
	
	public void update(ProfilUtilisateur profilUtilisateur) {
    entityManager.merge(profilUtilisateur)	;
    }	
	
	public void remove(Integer idProfil) {
		ProfilUtilisateur profilUtilisateur = entityManager.find(ProfilUtilisateur.class,idProfil );
		entityManager.remove(profilUtilisateur);
		
	}
	
	public ProfilUtilisateur findById(Integer idProfil) {
		return (ProfilUtilisateur) entityManager.find(ProfilUtilisateur.class, idProfil);
	}
}