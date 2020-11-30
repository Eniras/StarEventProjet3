package fr.isika.cdi6.starevent.services;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cdi6.starevent.data.model.admin.Admin;
import fr.isika.cdi6.starevent.repositories.AdminRepository;
@Stateless
public class AdminService {

	@Inject
	private AdminRepository adminRepository;
	
	public Admin findById(Integer idAdmin) {
		return (Admin) adminRepository.find(Admin.class, idAdmin);
	}
}
