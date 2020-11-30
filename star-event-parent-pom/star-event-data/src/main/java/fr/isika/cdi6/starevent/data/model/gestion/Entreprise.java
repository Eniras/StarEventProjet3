  
package fr.isika.cdi6.starevent.data.model.gestion;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import fr.isika.cdi6.starevent.data.model.enums.Type;

@Entity
@NamedQueries({
	@NamedQuery(name="Entreprise.findAll", query= "select e from Entreprise e" ),
	@NamedQuery(name ="Entreprise.findById", query = "select e from Entreprise e where id_entreprise = :id")
	
})
public class Entreprise {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_entreprise;

	//TODO : pensez à vérifier les champs not-null car 
	// soit il faut les initialiser avec quelque chose par défaut soit ils vont causer des exceptions de validation
//	@NotNull
	private String nomEntreprise;

	private String siret;

	@Enumerated(EnumType.STRING)
	private Type domaineActivite;

	private String numero;

	private String rue;

	private String ville;

	private String code_postal;

	private String pays;

	public Entreprise() {
	}

	public Integer getId_entreprise() {
		return id_entreprise;
	}

	public void setId_entreprise(Integer id_entreprise) {
		this.id_entreprise = id_entreprise;
	}

	public String getNomEntreprise() {
		return nomEntreprise;
	}

	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}

	public String getSiret() {
		return siret;
	}

	public void setSiret(String siret) {
		this.siret = siret;
	}

	public Type getDomaineActivite() {
		return domaineActivite;
	}

	public void setDomaineActivite(Type domaineActivite) {
		this.domaineActivite = domaineActivite;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCode_postal() {
		return code_postal;
	}

	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Entreprise [id_entreprise=");
		builder.append(id_entreprise);
		builder.append(", nomEntreprise=");
		builder.append(nomEntreprise);
		builder.append(", siret=");
		builder.append(siret);
		builder.append(", domaineActivite=");
		builder.append(domaineActivite);
		builder.append(", numero=");
		builder.append(numero);
		builder.append(", rue=");
		builder.append(rue);
		builder.append(", ville=");
		builder.append(ville);
		builder.append(", code_postal=");
		builder.append(code_postal);
		builder.append(", pays=");
		builder.append(pays);
		builder.append("]");
		return builder.toString();
	}

}