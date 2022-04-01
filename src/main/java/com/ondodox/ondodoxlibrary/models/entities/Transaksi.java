package com.ondodox.ondodoxlibrary.models.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "transaksis")
public class Transaksi {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_transaksi", nullable = false)
    private Long id;

    private boolean status;
    private Integer totalPembayaran;
    private Date tanggal;

    @OneToMany(mappedBy = "transaksi", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Peminjaman> peminjamen = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_pengguna")
    private Pengguna pengguna;

}
