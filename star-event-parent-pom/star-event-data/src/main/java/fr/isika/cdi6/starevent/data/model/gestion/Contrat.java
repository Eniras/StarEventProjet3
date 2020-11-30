package fr.isika.cdi6.starevent.data.model.gestion;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQueries({
@NamedQuery(name="Contrat.findAll", query= "select c from Contrat c" ),
@NamedQuery(name="Contrat.findByIdPartenaire", query = "select c from Contrat c where c.partenaire.idUtilisateur=:idPartenaire")
})
public class Contrat {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idContrat;

	@OneToOne
	private Partenaire partenaire;
	
	private String text;
	
	private String filePath;


	public Contrat() {
	}

	public Integer getId_contrat() {
		return idContrat;
	}

	public void setId_contrat(Integer id_contrat) {
		this.idContrat = id_contrat;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Partenaire getPartenaire() {
		return partenaire;
	}

	public void setPartenaire(Partenaire partenaire) {
		this.partenaire = partenaire;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Contrat [id_contrat=");
		builder.append(idContrat);
		builder.append(", filePath=");
		builder.append(filePath);
		builder.append(", text=");
		builder.append(text);
		builder.append("]");
		return builder.toString();
	}

}