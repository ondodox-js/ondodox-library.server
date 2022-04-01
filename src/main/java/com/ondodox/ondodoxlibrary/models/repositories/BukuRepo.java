package com.ondodox.ondodoxlibrary.models.repositories;

import com.ondodox.ondodoxlibrary.models.entities.Buku;
import org.springframework.data.repository.CrudRepository;

public interface BukuRepo extends CrudRepository<Buku, Long> {
}
