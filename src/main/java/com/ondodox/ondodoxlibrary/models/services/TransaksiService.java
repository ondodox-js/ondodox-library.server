package com.ondodox.ondodoxlibrary.models.services;

import com.ondodox.ondodoxlibrary.dto.Response.TransaksiResponse;
import com.ondodox.ondodoxlibrary.dto.TransaksiData;
import com.ondodox.ondodoxlibrary.helpers.DataToEntity;
import com.ondodox.ondodoxlibrary.models.entities.Peminjaman;
import com.ondodox.ondodoxlibrary.models.entities.Transaksi;
import com.ondodox.ondodoxlibrary.models.repositories.PeminjamanRepo;
import com.ondodox.ondodoxlibrary.models.repositories.TransaksiRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransaksiService {
    @Autowired
    private TransaksiRepo transaksiRepo;
    @Autowired
    private PeminjamanRepo peminjamanRepo;

    public ResponseEntity<Object> insert(Transaksi transaksi){
        try{
            Transaksi transaksi1 = transaksiRepo.save(transaksi);
            List<Peminjaman> peminjamanList = transaksi1.getPeminjamans();
            for (Peminjaman peminjaman : peminjamanList){
                peminjaman.setTransaksi(transaksi1);
            }
            peminjamanRepo.saveAll(peminjamanList);

            Transaksi transaksiData = transaksiRepo.findById(transaksi1.getId()).get();

            return new ResponseEntity<>(new TransaksiResponse(transaksiData), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public List<TransaksiResponse> findAll(){
        List<TransaksiResponse> responses = new ArrayList<>();
        for (Transaksi response : transaksiRepo.findAll()){
            responses.add(new TransaksiResponse(response));
        }

        return responses;
    }

    public TransaksiResponse find(Long id){
        try{
            Transaksi transaksi = transaksiRepo.findById(id).get();
            return new TransaksiResponse(transaksi);
        }catch (Exception e){
            return null;
        }
    }


}
