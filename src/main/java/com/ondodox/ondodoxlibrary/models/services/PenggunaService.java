package com.ondodox.ondodoxlibrary.models.services;

import com.ondodox.ondodoxlibrary.dto.LoginHandle;
import com.ondodox.ondodoxlibrary.dto.UserData;
import com.ondodox.ondodoxlibrary.helpers.Response;
import com.ondodox.ondodoxlibrary.models.entities.Pengguna;
import com.ondodox.ondodoxlibrary.models.repositories.PenggunaRepo;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PenggunaService {
    @Autowired
    private PenggunaRepo repo;

    public ResponseEntity<Object> findAll(){
        return new ResponseEntity<>(new Response(true, repo.findAll()), HttpStatus.OK);
    }

    public ResponseEntity<Object> insert(Pengguna penggunaBaru){
        StrongPasswordEncryptor encryptor = new StrongPasswordEncryptor();
        try {
            String sandiEncrypt = encryptor.encryptPassword(penggunaBaru.getKataSandi());
            penggunaBaru.setKataSandi(sandiEncrypt);

            return new ResponseEntity<>(new LoginHandle(true, "pengguna", repo.save(penggunaBaru)), HttpStatus.OK);
        }catch (Exception e){

            return new ResponseEntity<>(new Response(false, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Object> masuk(UserData akun){
        Pengguna pengguna = repo.findByEmail(akun.getEmail());
        if (pengguna != null){
            StrongPasswordEncryptor encryptor = new StrongPasswordEncryptor();
            if (encryptor.checkPassword(akun.getKataSandi(), pengguna.getKataSandi())){
                return new ResponseEntity<>(new LoginHandle(true, "pengguna", pengguna), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

}
