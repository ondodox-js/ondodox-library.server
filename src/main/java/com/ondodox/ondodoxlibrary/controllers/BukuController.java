package com.ondodox.ondodoxlibrary.controllers;

import com.ondodox.ondodoxlibrary.helpers.Response;
import com.ondodox.ondodoxlibrary.models.entities.Buku;
import com.ondodox.ondodoxlibrary.models.services.BukuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("buku")
public class BukuController {
    @Autowired
    private BukuService service;

    @GetMapping
    private ResponseEntity<Object> index(){
        return service.findAll();
    }

    @PostMapping()
    private ResponseEntity<Object> store(@Valid @RequestBody Buku request, Errors errors){
        if (errors.hasErrors()){
            return new ResponseEntity<>(new Response(false, errors.getAllErrors()), HttpStatus.BAD_REQUEST);
        }
        return service.insert(request);
    }

}
