package fr.isika.cdi6.starevent.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cdi6.starevent.dao.repositories.EvenementRepository;
import fr.isika.cdi6.starevent.dao.repositories.ReservationRepository;
import fr.isika.cdi6.starevent.data.model.gestion.Evenement;
import fr.isika.cdi6.starevent.data.model.gestion.Reservation;

@Stateless
public class ReservationService {

	@Inject
	ReservationRepository reservationRepository;

	@Inject
	EvenementRepository EvenementRepository;

//	public void ajouter(Reservation reservation, Integer id_evenement) {
//		Evenement evenement = EvenementRepository.findById(id_evenement);
//		reservationRepository.create(reservation);
//		evenement.ajouterReservation(reservation);
//
//	}
	
	public void ajouter(Reservation reservation, Integer idOffre) {
		reservationRepository.create(reservation, idOffre);
	}

	public void update(Reservation reservation) {
		reservationRepository.update(reservation);

	}

	public void retirer(Reservation reservation) {
		reservationRepository.remove(reservation);
	}

	public Reservation findById(Integer id_reservation) {
		return reservationRepository.findById(id_reservation);
	}

	public List<Reservation> findAll() {

		return reservationRepository.findAll();
	}

	public List<Reservation> findByIdEvenement(Integer i) {

		return reservationRepository.findByIdEvenement(i);
	}

	public List<Reservation> findByIdPartenaire(Integer idPartenaire) {

		return reservationRepository.findByIdPartenaire(idPartenaire);
	}
}