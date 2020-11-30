package fr.isika.cdi6.starevent.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cdi6.starevent.dao.repositories.ProfilUtilisateurRepository;
import fr.isika.cdi6.starevent.data.model.utilisateurs.ProfilUtilisateur;

@Stateless
public class ProfilUtilisateurService {	
	
			// TODO : pas de NEW dans JEE et CDI, il faut TOUT injecter
		@Inject
		private ProfilUtilisateurRepository repository;
		
		public void ajouter(ProfilUtilisateur profilUtilisateur) {
			repository.create(profilUtilisateur);
		}
		
		public void update(ProfilUtilisateur profilUtilisateur) {
			repository.update(profilUtilisateur);
			
		}
		
		public void retirer(Integer idUtilisateur) {
			repository.remove(idUtilisateur);
		}
		
		public ProfilUtilisateur findById(Integer idProfil) {
			return (ProfilUtilisateur) repository.findById(idProfil);
		}
		
		public List<ProfilUtilisateur> findAll() {
			return repository.findAll();
		}
}
