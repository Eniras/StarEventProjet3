package fr.isika.cdi6.starevent.data.model.taches;


import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import fr.isika.cdi6.starevent.data.model.enums.Statut;

@Entity
@NamedQueries({
	@NamedQuery(name="Tache.findAll", query="select t from Tache t")
	
})
public class Tache {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_tache;

	private LocalDate date_debut;

	private LocalDate date_fin;
	
	@Enumerated(EnumType.STRING)
	private Statut statutTache;
	
	private String description;

	public Tache() {
	}

	public Integer getId_tache() {
		return id_tache;
	}

	public void setId_tache(Integer id_tache) {
		this.id_tache = id_tache;
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

	public Statut getStatutTache() {
		return statutTache;
	}

	public void setStatutTache(Statut statutTache) {
		this.statutTache = statutTache;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Tache [id_tache=");
		builder.append(id_tache);
		builder.append(", date_debut=");
		builder.append(date_debut);
		builder.append(", date_fin=");
		builder.append(date_fin);
		builder.append(", statutTache=");
		builder.append(statutTache);
		builder.append(", description=");
		builder.append(description);
		builder.append("]");
		return builder.toString();
	}
	
	

}