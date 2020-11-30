package fr.isika.cdi6.starevent.repositories;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cdi6.starevent.data.model.admin.Admin;
@Stateless
public class AdminRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public Admin find(Class<Admin> class1, Integer idAdmin) {
		
		return this.entityManager.find(Admin.class, idAdmin);
	}
	
	
}
