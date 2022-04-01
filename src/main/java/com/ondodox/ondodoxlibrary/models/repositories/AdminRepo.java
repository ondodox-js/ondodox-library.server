package com.ondodox.ondodoxlibrary.models.repositories;

import com.ondodox.ondodoxlibrary.models.entities.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepo extends CrudRepository<Admin, Long> {
}
