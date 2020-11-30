package fr.isika.cdi6.starevent.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cdi6.starevent.dao.repositories.EntrepriseRepository;
import fr.isika.cdi6.starevent.data.model.gestion.Entreprise;
import fr.isika.cdi6.starevent.data.model.gestion.Partenaire;

@Stateless
public class EntrepriseService {

	
	// TODO : pas de NEW dans JEE et CDI, il faut TOUT injecter
		@Inject
		private EntrepriseRepository repository;
		
		public void ajouter(Entreprise entreprise, Partenaire partenaire) {
			repository.create(entreprise, partenaire.getIdUtilisateur());
			
		}

		public void update(Entreprise entreprise) {
			repository.update(entreprise);
			
		}

		public void retirer(Integer idEntreprise) {
			repository.remove(idEntreprise);
		}

		public Entreprise findById(Integer idEntreprise) {
			return repository.findById(idEntreprise);
		}
		
		public List<Entreprise> findAll() {
			 List<Entreprise> list = repository.findAll();
		//	 LOGGER.info("blabla test partner"+ list.get(0).getLogin());

			return list;
		}
}