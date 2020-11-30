package fr.isika.cdi6.starevent.data.model.taches;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import fr.isika.cdi6.starevent.data.model.admin.Admin;
import fr.isika.cdi6.starevent.data.model.enums.Type;

@Entity
@NamedQueries({ @NamedQuery(name = "ToDo.findAll", query = "select td from ToDo td"),
		@NamedQuery(name = "ToDo.findByPriority", query = "select td from ToDo td where td.typeToDo=:Typepriority"),
//		@NamedQuery(name = "ToDo.findTacheByIdToDo", query = "select td.taches from ToDo td where td.idToDo =:idToDo")

})
public class ToDo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idToDo;

	//bi
	@OneToOne
	private Admin admin;

	@Enumerated(EnumType.STRING)
	private Type typeToDo;

	//Unidirectionnel

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<Tache> taches;

	public ToDo() {
		taches = new ArrayList<Tache>();
	}

	public void ajouter(Tache tache) {
		this.taches.add(tache);
	}

	public void retirer(Tache tache) {
		this.taches.remove(tache);
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Type getTypeToDo() {
		return typeToDo;
	}

	public void setTypeToDo(Type typeToDo) {
		this.typeToDo = typeToDo;
	}

	public Integer getIdToDo() {
		return idToDo;
	}

	public void setIdToDo(Integer idToDo) {
		this.idToDo = idToDo;
	}

	public List<Tache> getTaches() {
		return taches;
	}

	public void setTaches(List<Tache> taches) {
		this.taches = taches;
	}

}
