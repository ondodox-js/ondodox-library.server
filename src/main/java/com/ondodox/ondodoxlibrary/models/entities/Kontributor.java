package com.ondodox.ondodoxlibrary.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Kontributors")
@Data
public class Kontributor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_kontributor", nullable = false)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String namaLengkap;

    @NotNull
    @Email
    @Column(unique = true, name = "email", nullable = false)
    private String email;

    @NotNull
    @Length(min = 8, message = "Minimal {min} digit dan Maksimal {max} digit")
    private String kataSandi;

    @Column(columnDefinition = "boolean default false")
    private boolean status;

    @OneToMany(mappedBy = "kontributor", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties({"kontributor"})
    private List<Buku> bukus = new ArrayList<>();
}
