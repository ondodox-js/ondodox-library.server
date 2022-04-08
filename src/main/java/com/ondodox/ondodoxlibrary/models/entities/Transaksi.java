package com.ondodox.ondodoxlibrary.models.entities;

import lombok.*;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EnableJpaAuditing
@Entity(name = "transaksis")
public class Transaksi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaksi", nullable = false)
    private Long id;

    @Column(columnDefinition = "boolean default false")
    private boolean status;

    private Long totalPembayaran;
    @Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date tanggalTransaksi;

    @OneToMany(mappedBy = "transaksi", cascade = CascadeType.MERGE, orphanRemoval = true)
    private List<Peminjaman> peminjamans = new ArrayList<>();

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_pengguna")
    private Pengguna pengguna;

}
