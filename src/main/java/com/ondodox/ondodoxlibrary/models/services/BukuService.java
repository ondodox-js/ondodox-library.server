package com.ondodox.ondodoxlibrary.models.services;

import com.ondodox.ondodoxlibrary.helpers.Response;
import com.ondodox.ondodoxlibrary.models.entities.Buku;
import com.ondodox.ondodoxlibrary.models.repositories.BukuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BukuService {
    @Autowired
    private BukuRepo repo;

    public ResponseEntity<Object> findAll(){
        return new ResponseEntity<>(new Response(true, repo.findAll()), HttpStatus.OK);
    }
    public ResponseEntity<Object> insert(Buku bukuBaru){
        try {

            return new ResponseEntity<>(new Response(true, repo.save(bukuBaru)), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new Response(false, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
