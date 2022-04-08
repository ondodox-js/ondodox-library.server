package com.ondodox.ondodoxlibrary.models.repositories;

import com.ondodox.ondodoxlibrary.models.entities.Transaksi;
import org.springframework.data.repository.CrudRepository;

public interface TransaksiRepo extends CrudRepository<Transaksi, Long> {
}
