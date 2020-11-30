package fr.isika.cdi6.starevent.dao.repositories;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cdi6.starevent.data.model.gestion.Reservation;
import fr.isika.cdi6.starevent.data.model.offres.Offre;

@Stateless
public class ReservationRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	public ReservationRepository() {
	}

	public List<Reservation> findAll() {
		return entityManager.createNamedQuery("Reservation.findAll", Reservation.class).getResultList();
	}
	
	public List<Reservation> findByIdEvenement(Integer idEvenement){
		return entityManager.createNamedQuery("Reservation.findByIdEvenement", Reservation.class).
				setParameter("idEvenement", idEvenement).getResultList();
	}
	
	public List<Reservation> findByIdPartenaire(Integer idPartenaire){
		return entityManager.createNamedQuery("Reservation.findByIdPartenaire", Reservation.class).
				setParameter("idPartenaire", idPartenaire).getResultList();
	}

	public void create(Reservation reservation, Integer idOffre) {
		this.entityManager.persist(reservation);
		Offre offre = (Offre) this.entityManager.find(Offre.class, idOffre);
		reservation.setOffre(offre);
		this.update(reservation);

	}

	public void update(Reservation reservation) {
		this.entityManager.merge(reservation);
	}

	public void remove(Reservation reservation) {
		this.entityManager.remove(reservation);
	}

	public Reservation findById(Integer id_reservation) {
		return entityManager.find(Reservation.class, id_reservation);
	}
}