package fr.isika.cdi6.starevent.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cdi6.starevent.dao.repositories.CatalogueRepository;
import fr.isika.cdi6.starevent.dao.repositories.OffreRepository;
import fr.isika.cdi6.starevent.dao.repositories.PartenaireRepository;
import fr.isika.cdi6.starevent.data.model.gestion.Partenaire;
import fr.isika.cdi6.starevent.data.model.offres.CatalogueOffres;
import fr.isika.cdi6.starevent.data.model.offres.Offre;

@Stateless
public class OffreService {
	
	
	@Inject
	PartenaireRepository partRepo;
	
	@Inject
	OffreRepository offreRepo;
	
	@Inject
	CatalogueRepository catalogueRepo;

	public void ajouter(Offre offre, Integer idPartenaire) {
		
		offreRepo.create(offre);
		
		Partenaire partenaire = partRepo.findById(idPartenaire);
		
		CatalogueOffres catalogue = partenaire.getCataloguePartenaires();
		
		catalogue.ajouter(offre);
		
		catalogueRepo.update(catalogue);
		
		partRepo.update(partenaire);		
	}

	public void update(Offre offre) {
		offreRepo.update(offre);
	}

	public void remove(Offre offre) {
		Offre offreBD = offreRepo.findById(offre.getIdOffre());
		
		if (offreBD != null) {
			CatalogueOffres catalogue = offreBD.getPartenaire().getCataloguePartenaires();
			catalogue.retirer(offreBD);
			catalogueRepo.update(catalogue);
			offreRepo.remove(offreBD.getIdOffre());
		}
	}
	
	
	public List<Offre> findAll(){
		return offreRepo.findAll();
	}
}
