package com.groupe10.projet_fin_detude_L3.services.servicesImpl;

import com.groupe10.projet_fin_detude_L3.dao.AdminRepository;
import com.groupe10.projet_fin_detude_L3.dao.UsersRepository;
import com.groupe10.projet_fin_detude_L3.models.Admin;
import com.groupe10.projet_fin_detude_L3.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;


    @Override
    public Admin addAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public Admin getOneAdmin(int idAdmin) {
        return adminRepository.findById(idAdmin).get();
    }

    @Override
    public Admin updateAdmin(int idAdmin, Admin admin) {
        Admin adminToUpdate = adminRepository.findById(idAdmin).get();
        adminToUpdate.setPrenom(admin.getPrenom());
        adminToUpdate.setNom(admin.getNom());
        adminToUpdate.setEmail(admin.getEmail());
        adminToUpdate.setPassword(admin.getPassword());
        adminToUpdate.setTelephone(admin.getTelephone());
        adminToUpdate.setAdresse(admin.getAdresse());
        adminToUpdate.setHospitalName(admin.getHospitalName());
        adminToUpdate.setRole(admin.getRole());
        adminToUpdate.setEnabled(admin.isEnabled());

        return adminRepository.save(adminToUpdate);
    }
}
