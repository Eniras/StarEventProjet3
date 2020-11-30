package fr.isika.cdi6.starevent.data.model.gestion;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

import fr.isika.cdi6.starevent.data.model.enums.Statut;
import fr.isika.cdi6.starevent.data.model.offres.Offre;

@Entity
@NamedQueries({
@NamedQuery(name="Reservation.findAll", query= "select r from Reservation r"),
@NamedQuery(name="Reservation.findByIdEvenement", query= "select r from Reservation r inner join r.evenement as RE where RE.id_evenement =:idEvenement"),
@NamedQuery(name="Reservation.findByIdPartenaire", query= "select r from Reservation r inner join r.partenaire as RP where RP.idUtilisateur =:idPartenaire")
})
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_reservation;

	private LocalDate date_debut;
	
	private LocalDate date_fin;

	@Enumerated(EnumType.STRING)
	private Statut statutReservation;

	private int nbInvites;

	@ManyToOne//unidir
	private Partenaire partenaire;

	@ManyToOne//bidir
	private Evenement evenement;

	@ManyToOne//unidir
	private Offre offre;

	public Reservation() {
	}

	public Integer getId_reservation() {
		return id_reservation;
	}

	public void setId_reservation(Integer id_reservation) {
		this.id_reservation = id_reservation;
	}

	public LocalDate getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(LocalDate date_debut) {
		this.date_debut = date_debut;
	}

	public LocalDate getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(LocalDate date_fin) {
		this.date_fin = date_fin;
	}

	public Statut getStatutReservation() {
		return statutReservation;
	}

	public void setStatutReservation(Statut statutReservation) {
		this.statutReservation = statutReservation;
	}

	public int getNbInvites() {
		return nbInvites;
	}

	public void setNbInvites(int nbInvites) {
		this.nbInvites = nbInvites;
	}

	public Partenaire getPartenaire() {
		return partenaire;
	}

	public void setPartenaire(Partenaire partenaire) {
		this.partenaire = partenaire;
	}

	public Evenement getEvenement() {
		return evenement;
	}

	public void setEvenement(Evenement evenement) {
		this.evenement = evenement;
	}

	public Offre getOffre() {
		return offre;
	}

	public void setOffre(Offre offre) {
		this.offre = offre;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Reservation [id_reservation=");
		builder.append(id_reservation);
		builder.append(", date_debut=");
		builder.append(date_debut);
		builder.append(", date_fin=");
		builder.append(date_fin);
		builder.append(", statutReservation=");
		builder.append(statutReservation);
		builder.append(", nbInvites=");
		builder.append(nbInvites);
		builder.append("]");
		return builder.toString();
	}
	
	
}