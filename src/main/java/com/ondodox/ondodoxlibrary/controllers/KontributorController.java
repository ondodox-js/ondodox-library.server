package com.ondodox.ondodoxlibrary.controllers;

import com.ondodox.ondodoxlibrary.dto.UserData;
import com.ondodox.ondodoxlibrary.helpers.Response;
import com.ondodox.ondodoxlibrary.models.entities.Kontributor;
import com.ondodox.ondodoxlibrary.models.services.BukuService;
import com.ondodox.ondodoxlibrary.models.services.KontributorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("kontributor")
@CrossOrigin(origins = "*")
public class KontributorController {
    @Autowired
    private KontributorService service;


    @GetMapping
    private ResponseEntity<Object> index(){
        return service.findAll();
    }

    @PostMapping()
    private ResponseEntity<Object> store(@Valid @RequestBody Kontributor request, Errors errors){
        if (errors.hasErrors()){
            return new ResponseEntity<>(new Response(false, errors.getAllErrors()), HttpStatus.BAD_REQUEST);
        }
        return service.insert(request);
    }

    @PostMapping("login")
    private ResponseEntity<Object> login(@Valid @RequestBody UserData user, Errors errors){
        if (errors.hasErrors()){
            return new ResponseEntity<>(new Response(false, errors.getAllErrors()), HttpStatus.BAD_REQUEST);
        }
        return service.login(user);
    }

    @GetMapping("{id}/buku-ku")
    private ResponseEntity<Object> bukuKu(@PathVariable("id") Long id){
        return service.bukuKu(id);
    }

}
