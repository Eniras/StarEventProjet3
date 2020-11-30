package fr.isika.cdi6.starevent.web.managedbeans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import fr.isika.cdi6.starevent.dao.repositories.ApplicationRepository;

//@Named
//@ViewScoped
public class ApplicationManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	@EJB
	private ApplicationRepository repo;

	public ApplicationManagedBean() {
	}

	public void test() {
	}
}
