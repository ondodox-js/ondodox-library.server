package com.ondodox.ondodoxlibrary.models.repositories;

import com.ondodox.ondodoxlibrary.models.entities.Buku;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BukuRepo extends CrudRepository<Buku, Long> {
    List<Buku> findBukuByKontributor_Id(Long id);
    List<Buku> findByStatus(boolean status);
    List<Buku> findTop6ByStatusOrderByTanggalDesc(boolean status);

}
