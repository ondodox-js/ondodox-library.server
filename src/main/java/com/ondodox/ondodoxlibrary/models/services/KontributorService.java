package com.ondodox.ondodoxlibrary.models.services;

import com.ondodox.ondodoxlibrary.dto.LoginHandle;
import com.ondodox.ondodoxlibrary.dto.UserData;
import com.ondodox.ondodoxlibrary.helpers.Response;
import com.ondodox.ondodoxlibrary.models.entities.Kontributor;
import com.ondodox.ondodoxlibrary.models.repositories.KontributorRepo;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class KontributorService {
    @Autowired
    private KontributorRepo repo;

    public ResponseEntity<Object> findAll(){
        return new ResponseEntity<>(new Response(true, repo.findAll()), HttpStatus.OK);
    }

    public ResponseEntity<Object> insert(Kontributor kontributorBaru){
        StrongPasswordEncryptor encryptor = new StrongPasswordEncryptor();
        try{
            kontributorBaru.setKataSandi(encryptor.encryptPassword(kontributorBaru.getKataSandi()));
            return new ResponseEntity<>(new Response(true, repo.save(kontributorBaru)), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new Response(false, e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Object> login(UserData user){
        if (repo.findByEmail(user.getEmail()) != null){
            //lanjut login
            Kontributor kontributor = repo.findByEmail(user.getEmail());
            StrongPasswordEncryptor encryptor = new StrongPasswordEncryptor();
            if (encryptor.checkPassword(user.getKataSandi(), kontributor.getKataSandi())){
                return new ResponseEntity<>(new LoginHandle(true,"kontributor", kontributor),HttpStatus.OK);
            }
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);

        }
        return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<Object> bukuKu(Long id){
        if (repo.findById(id).isPresent()){
            return new ResponseEntity<>( repo.findById(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Response(false, null), HttpStatus.NOT_FOUND);
    }
}
