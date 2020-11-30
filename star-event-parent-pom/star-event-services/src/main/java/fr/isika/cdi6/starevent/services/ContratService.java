package fr.isika.cdi6.starevent.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cdi6.starevent.dao.repositories.ContratRepository;
import fr.isika.cdi6.starevent.dao.repositories.UtilisateurRepository;
import fr.isika.cdi6.starevent.data.model.gestion.Contrat;

@Stateless
public class ContratService {

	// TODO : pas de NEW dans JEE et CDI, il faut TOUT injecter
	@Inject
	private ContratRepository repository;
	
	@Inject
	private UtilisateurRepository utilisateurRepository;

	public void ajouter(Contrat contrat, Integer idPartenaire) {
		repository.create(contrat, idPartenaire);
		repository.update(contrat);
	}

	public void update(Contrat contrat) {
		repository.update(contrat);
	}

	public void retirer(Integer idContrat) {
		repository.remove(idContrat);
	}

	public Contrat findById(Integer idContrat) {
		return (Contrat) repository.findById(idContrat);
	}

	public Contrat findByIdPartenaire(Integer idPartenaire) {
		return (Contrat) repository.findByIdPartenaire(idPartenaire);
	}
	
	public List<Contrat> findAll() {
		List<Contrat> list = repository.findAll();

		return list;
	}

}
