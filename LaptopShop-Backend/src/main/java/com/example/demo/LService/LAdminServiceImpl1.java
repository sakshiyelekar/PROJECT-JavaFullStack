package com.example.demo.LService;

import com.example.demo.LEntity.LAdmin;
import com.example.demo.LRepository.LAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import javax.transaction.Transactional;

@Service
public class LAdminServiceImpl1 implements LAdminService {

    private final LAdminRepository adminRepo;

    @Autowired
    public LAdminServiceImpl1(LAdminRepository adminRepo) {
        this.adminRepo = adminRepo;
    }

    @Override
    public LAdmin saveAdmin(LAdmin admin) {
        return adminRepo.save(admin);
    }
    
    
    
    //Saving fixed ADMIN Credentials.
    @Transactional
    public LAdmin saveDefaultAdmin() {
        LAdmin defaultAdmin = new LAdmin();
        defaultAdmin.setUsername("laptop");
        defaultAdmin.setPassword("shop");
        return adminRepo.save(defaultAdmin);
    }
 /* Example logging in saveAdmin method
    @Override
    public LAdmin saveAdmin(LAdmin admin) {
        System.out.println("Saving admin: " + admin);
        LAdmin savedAdmin = adminRepo.save(admin);
        System.out.println("Admin saved: " + savedAdmin);
        return savedAdmin;
    }*/


    
    @Override
    public List<LAdmin> getAllAdmins() {
        return adminRepo.findAll();
    }

    @Override
    public LAdmin getAdminById(Long id) {
        return adminRepo.findById(id).orElse(null);
    }

    @Override
    public LAdmin updateAdmin(Long id, LAdmin admin) {
        LAdmin existingAdmin = adminRepo.findById(id).orElse(null);
        if (existingAdmin != null) {
            existingAdmin.setUsername(admin.getUsername());
            existingAdmin.setPassword(admin.getPassword());
            return adminRepo.save(existingAdmin);
        }
        return null;
    }

    @Override
    public void deleteAdmin(Long id) {
        adminRepo.deleteById(id);
    }

    
	@Override
	public LAdmin registerAdmin(LAdmin admin) {
		// TODO Auto-generated method stub
	    return adminRepo.save(admin);
	}
	
	
	

	@Override
	public LAdmin loginAdmin(String username, String password) {
	    // Find the admin by username
	    LAdmin admin = adminRepo.findByUsername(username);

	    if (admin != null && admin.getPassword().equals(password)) {
	        // Admin found and password matches, return the admin
	        return admin;
	    } else {
	        // Admin not found or password doesn't match, return null
	        return null;
	    }
	}

	@Override
	public LAdmin saveDefaultAdmin(LAdmin admin) {
		// TODO Auto-generated method stub
		return null;
	}

}

