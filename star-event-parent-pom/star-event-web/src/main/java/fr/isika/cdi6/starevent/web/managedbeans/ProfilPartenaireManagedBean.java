package fr.isika.cdi6.starevent.web.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import fr.isika.cdi6.starevent.data.model.gestion.Partenaire;
import fr.isika.cdi6.starevent.data.model.offres.Offre;
import fr.isika.cdi6.starevent.services.OffreService;
import fr.isika.cdi6.starevent.services.PartenaireService;

@Named("profilPartenaireMb")
@SessionScoped
public class ProfilPartenaireManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private int offersNb = 4000;
	private int reservationsNb=6000;
	private int eventsNb=6000;
	
	
	@Inject
	private static LoginManagedBean loginMb;
	

	@Inject
	private PartenaireService partenaireService;

	@Inject
	private OffreService offreService;

	private List<Offre> offres = new ArrayList<>();

	@PostConstruct
	public void init() {

		Integer idUtilisateur = loginMb.getId();
		Partenaire partenaireEnregistre = partenaireService.findById(idUtilisateur);
		offres = partenaireEnregistre.getCataloguePartenaires().getOffres();

	}
	
	public LoginManagedBean getLoginMb() {
		return loginMb;
	}

	public void setLoginMb(LoginManagedBean loginMb) {
		this.loginMb = loginMb;
	}

	public PartenaireService getPartenaireService() {
		return partenaireService;
	}

	public void setPartenaireService(PartenaireService partenaireService) {
		this.partenaireService = partenaireService;
	}

	public OffreService getOffreService() {
		return offreService;
	}

	public void setOffreService(OffreService offreService) {
		this.offreService = offreService;
	}

	public List<Offre> getOffres() {
		return offres;
	}

	public void setOffres(List<Offre> offres) {
		this.offres = offres;
	}

	
	public int getOffersNb() {
		return offersNb;
	}
	public void setOffersNb(int offersNb) {
		this.offersNb = offersNb;
	}
	public int getReservationsNb() {
		return reservationsNb;
	}
	public void setReservationsNb(int reservationsNb) {
		this.reservationsNb = reservationsNb;
	}
	public int getEventsNb() {
		return eventsNb;
	}
	public void setEventsNb(int eventsNb) {
		this.eventsNb = eventsNb;
	}


}
