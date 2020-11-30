package fr.isika.cdi6.starevent.data.model.utilisateurs;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@DiscriminatorColumn(name = "Type_Utilisateur", discriminatorType = DiscriminatorType.STRING)
@Inheritance(strategy = InheritanceType.JOINED)

@NamedQueries({
@NamedQuery(name = "Utilisateur.findAll", query = "select u from Utilisateur u"),
@NamedQuery(name = "Utilisateur.findByLogin", query = "select u from Utilisateur u where u.login=:loginUtilisateur")

})
public abstract class Utilisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Integer idUtilisateur;

	// je rajoute un type utilisateur (client/partenaire)
	protected String typeUtilisateur;

	protected String login;

	protected String password;

	public Utilisateur() {
	}

	public Integer getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Integer idUser) {
		this.idUtilisateur = idUser;
	}

	public String getTypeUtilisateur() {
		return typeUtilisateur;
	}

	public void setTypeUtilisateur(String typeUtilisateur) {
		this.typeUtilisateur = typeUtilisateur;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Utilisateur [login=");
		builder.append(login);
		builder.append(", password=");
		builder.append(password);
		builder.append("]");
		return builder.toString();
	}

}