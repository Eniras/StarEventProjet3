package fr.isika.cdi6.starevent.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cdi6.starevent.dao.repositories.DashboardRepository;
import fr.isika.cdi6.starevent.dao.repositories.EvenementRepository;
import fr.isika.cdi6.starevent.dao.repositories.ReservationRepository;
import fr.isika.cdi6.starevent.data.model.gestion.Evenement;
import fr.isika.cdi6.starevent.data.model.gestion.Reservation;
import fr.isika.cdi6.starevent.data.model.utilisateurs.DashboardClient;

@Stateless
public class EvenementService {
	@Inject
	EvenementRepository evenementRepo;
	@Inject
	ReservationRepository reservationRepo;
	@Inject
	DashboardRepository dashboardRepo;

	public void ajouter(Evenement evenement, Integer idDashboard) {
		evenementRepo.create(evenement);
		DashboardClient dashboard = dashboardRepo.findById(idDashboard);
		evenement.setDashboardClient(dashboard);
		dashboard.ajouter(evenement);
		dashboardRepo.update(dashboard);
	}

	public void update(Evenement evenement) {
		evenementRepo.update(evenement);
	}

	public void remove(Evenement evenement) {
		for (Reservation reservation : evenement.getReservations()) {
			reservationRepo.remove(reservation);
		}
		evenementRepo.remove(evenement.getId_evenement());
	}

	public List<Evenement> findAll() {
		return evenementRepo.findAll();
	}
	
	public Evenement findById(Integer idEvenement) {
		return evenementRepo.findById(idEvenement);
	}
	
	public List<Evenement> findByIdDash(Integer idDashboard) {
		return evenementRepo.findByIdDash(idDashboard);
	}

}