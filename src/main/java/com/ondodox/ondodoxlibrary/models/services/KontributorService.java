package com.ondodox.ondodoxlibrary.models.services;

import com.ondodox.ondodoxlibrary.helpers.Response;
import com.ondodox.ondodoxlibrary.models.entities.Kontributor;
import com.ondodox.ondodoxlibrary.models.repositories.KontributorRepo;
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
        try{
            return new ResponseEntity<>(new Response(true, repo.save(kontributorBaru)), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new Response(false, e), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
