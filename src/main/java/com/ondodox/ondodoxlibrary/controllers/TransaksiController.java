package com.ondodox.ondodoxlibrary.controllers;

import com.ondodox.ondodoxlibrary.dto.Response.TransaksiResponse;
import com.ondodox.ondodoxlibrary.models.services.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("transaksi")
public class TransaksiController {
    @Autowired
    private TransaksiService service;

    @GetMapping()
    private ResponseEntity<Object> index(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    private ResponseEntity<Object> show(@PathVariable("id") Long id){
        TransaksiResponse response = service.find(id);
        if (response != null){
            return new ResponseEntity<>(service.find(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}
