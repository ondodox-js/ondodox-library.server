package com.ondodox.ondodoxlibrary.models.entities;

import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity(name = "peminjamans")
public class Peminjaman {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_peminjaman", nullable = false)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_buku")
    private Buku buku;

    @Column(columnDefinition = "DATE DEFAULT CURRENT_DATE", nullable = false)
    private Date tanggalPeminjaman;

    @Column(nullable = false)
    private Date tanggalKembali;

    private boolean status;

    private Long jumlah;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_transaksi")
    private Transaksi transaksi;

}
