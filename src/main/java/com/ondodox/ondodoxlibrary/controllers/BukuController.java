package com.ondodox.ondodoxlibrary.controllers;

import com.ondodox.ondodoxlibrary.dto.BukuData;
import com.ondodox.ondodoxlibrary.helpers.Response;
import com.ondodox.ondodoxlibrary.models.entities.Transaksi;
import com.ondodox.ondodoxlibrary.models.services.BukuService;
import com.ondodox.ondodoxlibrary.models.services.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("buku")
@CrossOrigin(origins = "*")
public class BukuController {
    @Autowired
    private BukuService service;
    @Autowired
    private TransaksiService transaksiService;

    @GetMapping
    private ResponseEntity<Object> index(){
        return service.findAll();
    }

    @PostMapping(
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    private ResponseEntity<Object> store(@Validated BukuData request, Errors errors){
        if (errors.hasErrors()){
            return new ResponseEntity<>(new Response(false, errors.getAllErrors()), HttpStatus.BAD_REQUEST);
        }
         return service.insert(request);
    }

    @GetMapping("pending")
    private ResponseEntity<Object> bukuPending(){
        return service.bukuPending();
    }

    @PostMapping("peminjaman")
    private ResponseEntity<Object> peminjaman(@Valid @RequestBody Transaksi transaksi, Errors errors){
        if (errors.hasErrors()){
            return new ResponseEntity<>(errors.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        return transaksiService.insert(transaksi);
    }

}
