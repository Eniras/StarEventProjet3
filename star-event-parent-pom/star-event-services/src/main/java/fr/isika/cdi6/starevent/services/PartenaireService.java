package fr.isika.cdi6.starevent.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cdi6.starevent.dao.repositories.PartenaireRepository;
import fr.isika.cdi6.starevent.dao.repositories.UtilisateurRepository;
import fr.isika.cdi6.starevent.data.model.gestion.Partenaire;

@Stateless
public class PartenaireService {

	// TODO : pas de NEW dans JEE et CDI, il faut TOUT injecter
	@Inject
	private PartenaireRepository repository;
	
	@Inject
	private UtilisateurRepository utilisateurRepository;
	
	
	public void ajouter(Partenaire partenaire) {
		
		Integer idUtilisateur = utilisateurRepository.create(partenaire);
	
		repository.create(partenaire);
		
		partenaire.setIdUtilisateur(idUtilisateur);
		repository.update(partenaire);

	}

	public void update(Partenaire partenaire) {
		repository.update(partenaire);
		
	}

	public void retirer(Integer idPartenaire) {
		repository.remove(idPartenaire);
	}

	public Partenaire findById(Integer idPartenaire) {
		return (Partenaire) repository.findById(idPartenaire);
	}
	
	public List<Partenaire> findAll() {
		 List<Partenaire> list = repository.findAll();

		return list;
	}
	
}
