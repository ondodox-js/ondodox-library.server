package com.ondodox.ondodoxlibrary.models.entities;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Bukus")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Buku {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(columnDefinition = "boolean default false")
    private boolean status;

    @NotNull
    private Long stok;

    private String gambar;

    @Lob
    @NotNull
    private String sinopsis;

    @ManyToOne()
    @JsonIgnoreProperties({"bukus"})
    @JoinColumn(name = "id_kontributor")
    private Kontributor kontributor;
}
