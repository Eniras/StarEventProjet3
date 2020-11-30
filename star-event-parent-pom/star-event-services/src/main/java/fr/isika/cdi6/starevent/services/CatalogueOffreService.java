package fr.isika.cdi6.starevent.services;


import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cdi6.starevent.dao.repositories.CatalogueRepository;
import fr.isika.cdi6.starevent.dao.repositories.OffreRepository;
import fr.isika.cdi6.starevent.dao.repositories.PartenaireRepository;
import fr.isika.cdi6.starevent.data.model.gestion.Partenaire;
import fr.isika.cdi6.starevent.data.model.offres.CatalogueOffres;
import fr.isika.cdi6.starevent.data.model.offres.Offre;

@Stateless
public class CatalogueOffreService {
	@Inject
	PartenaireRepository partRepo;
	@Inject
	OffreRepository offreRepo;
	@Inject
	CatalogueRepository catalogueRepo;

	public void ajouter(CatalogueOffres catalogue, Integer idPartenaire) {
		catalogueRepo.create(catalogue);
		Partenaire partenaire = partRepo.findById(idPartenaire);
		partenaire.setCataloguePartenaires(catalogue);
		partRepo.update(partenaire);
		
	}

	public void update(CatalogueOffres catalogue) {
		catalogueRepo.update(catalogue);
	}

	public void remove(CatalogueOffres catalogue) {
		Partenaire partenaire = partRepo.findById(catalogue.getOffres().get(0).getPartenaire().getIdUtilisateur());
		for (Offre offre : catalogue.getOffres()) {
			offreRepo.remove(offre.getIdOffre()); 
		}
		catalogueRepo.remove(catalogue.getId_Catalogue());
	}
}
