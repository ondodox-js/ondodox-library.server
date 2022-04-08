package com.ondodox.ondodoxlibrary.models.repositories;

import com.ondodox.ondodoxlibrary.models.entities.Kontributor;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface KontributorRepo extends CrudRepository<Kontributor, Long> {
    Kontributor findByEmail(String email);
    Optional<Kontributor> findById(Long id);
}
