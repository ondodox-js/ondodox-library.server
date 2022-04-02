package com.ondodox.ondodoxlibrary.models.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Bukus")
@Data
@CrossOrigin(origins = "*")
public class Buku {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_buku", nullable = false)
    private Long id;

    @NotNull
    private String judul;

    @NotNull
    private String pengarang;

    @NotNull
    private String penerbit;

    @NotNull
    private String tahunTerbit;

    @NotNull
    private Long stok;

    @ManyToOne()
    @JsonIgnoreProperties({"bukus"})
    @JoinColumn(name = "id_kontributor")
    private Kontributor kontributor;
}
