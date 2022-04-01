package com.ondodox.ondodoxlibrary.controllers;

import com.ondodox.ondodoxlibrary.helpers.Response;
import com.ondodox.ondodoxlibrary.models.entities.Pengguna;
import com.ondodox.ondodoxlibrary.models.services.PenggunaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("pengguna")
public class PenggunaController {
    @Autowired
    private PenggunaService service;

    @GetMapping
    public ResponseEntity<Object> index(){
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<Object> store(@Valid @RequestBody Pengguna pengguna, Errors errors){
        if (errors.hasErrors()){
            return new ResponseEntity<>(new Response(false, errors.getAllErrors()), HttpStatus.BAD_REQUEST);
        }
        return service.insert(pengguna);
    }
}
