package com.ondodox.ondodoxlibrary.models.entities;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "penggunas")
@Data
public class Pengguna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pengguna")
    private Long id;

    @NotNull
    @Email
    @Column(unique = true)
    private String email;

    @NotNull
    private String namaLengkap;

    @NotNull
    @Length(min = 8, message = "Minimal {min} digit dan Maksimal {max} digit")
    private String kataSandi;

    @Column(columnDefinition = "boolean default false")
    private boolean status;


}
