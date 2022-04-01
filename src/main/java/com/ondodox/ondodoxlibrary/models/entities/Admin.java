package com.ondodox.ondodoxlibrary.models.entities;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "Admins")
@Data
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_admin", nullable = false)
    private Long id;

    @Column(name = "nama_pengguna", unique = true, nullable = false)
    private String namaPengguna;

    @Column(name = "kata_sandi", nullable = false)
    private String kataSandi;
}
