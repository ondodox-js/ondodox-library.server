package com.ondodox.ondodoxlibrary.models.services;

import com.ondodox.ondodoxlibrary.helpers.admin.AdminRequest;
import com.ondodox.ondodoxlibrary.helpers.admin.AdminResponse;
import com.ondodox.ondodoxlibrary.models.entities.Admin;
import com.ondodox.ondodoxlibrary.models.repositories.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminRepo repo;
    public List<Admin> findAll(){
        return (List<Admin>) repo.findAll();
    }
    public AdminResponse insert(AdminRequest request){
        AdminResponse response = new AdminResponse();
        Admin adminBaru = new Admin();
        adminBaru.setNamaPengguna(request.getNamaPengguna());
        adminBaru.setKataSandi(request.kataSandiEncrypted());
        try {
            response.setResponse(repo.save(adminBaru));
            response.setStatus(true);
        }catch (Exception e){
            response.setResponse(e.getLocalizedMessage());
            response.setStatus(false);
        }
        return response;
    }
}
