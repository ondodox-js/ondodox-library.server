package com.ondodox.ondodoxlibrary.models.services;

import com.ondodox.ondodoxlibrary.dto.BukuData;
import com.ondodox.ondodoxlibrary.dto.EmailData;
import com.ondodox.ondodoxlibrary.helpers.DataToEntity;
import com.ondodox.ondodoxlibrary.helpers.Response;
import com.ondodox.ondodoxlibrary.models.entities.Buku;
import com.ondodox.ondodoxlibrary.models.repositories.BukuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class BukuService {
    @Autowired
    private BukuRepo repo;

    @Autowired
    private MailServices mailServices;

    public ResponseEntity<Object> findAll(){
        return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
    }
    public ResponseEntity<Object> insert(BukuData bukuBaru){
        try {
            Buku buku = uploadCoverandSave(bukuBaru);
            if ( buku != null){
                return new ResponseEntity<>(new Response(true, buku), HttpStatus.OK);
            }
            return new ResponseEntity<>(new Response(false, "Gagal memasukkan gambar"), HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            return new ResponseEntity<>(new Response(false, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public Buku uploadCoverandSave(BukuData data){
        Buku buku = DataToEntity.buku(data);
        repo.save(buku);
        String folderImage = System.getProperty("user.dir") + "/src/main/resources/static/images/covers/";
        File file = new File(folderImage);
        if (!file.exists()) {
            //noinspection ResultOfMethodCallIgnored
            file.mkdirs();
        }
        try{
            data.getGambar().transferTo(new File(folderImage + buku.getGambar()));
            return buku;
        }catch (Exception e){
            return null;
        }
    }

    public ResponseEntity<Object> find(Long id){
        return new ResponseEntity<>(repo.findBukuByKontributor_Id(id), HttpStatus.OK);
    }

    public ResponseEntity<Object> bukuPending(){
        return new ResponseEntity<>(repo.findByStatus(false), HttpStatus.OK);
    }

    public Response rilisBuku(Buku buku){
        Buku data = repo.findById(buku.getId()).get();
        EmailData email = new EmailData();
        email.setTo(data.getKontributor().getEmail());
        email.setSubject("Selamat, buku anda di terima!");
        email.setComponent(data.bodyEmailRilis());

        try {
            buku.setStatus(true);
            repo.save(buku);
            mailServices.send(email);
            return new Response(true, data);
        }catch (Exception e){
            return new Response(false, data);
        }
    }

    public ResponseEntity<Object> top6(){
        return new ResponseEntity<>(repo.findTop6ByStatusOrderByTanggalDesc(true), HttpStatus.OK);
    }
}
