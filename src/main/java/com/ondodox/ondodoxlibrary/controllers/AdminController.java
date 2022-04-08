package com.ondodox.ondodoxlibrary.controllers;

import com.ondodox.ondodoxlibrary.helpers.admin.AdminRequest;
import com.ondodox.ondodoxlibrary.helpers.admin.AdminResponse;
import com.ondodox.ondodoxlibrary.models.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("admin")
@CrossOrigin(origins = "*")
public class AdminController {
    @Autowired
    private AdminService service;

    @PostMapping("login")
    public ResponseEntity<Object> login(@Valid @RequestBody AdminRequest request, Errors errors){
        if (errors.hasErrors()){
            return new ResponseEntity<>(errors.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(service.insert(request), HttpStatus.OK);
    }
}
