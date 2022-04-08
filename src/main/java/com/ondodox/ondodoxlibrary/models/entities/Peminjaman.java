package com.ondodox.ondodoxlibrary.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "peminjamans")
public class Peminjaman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_peminjaman")
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_buku")
    private Buku buku;

    @Column(nullable = false)
    private Date tanggalKembali;

    @Column(columnDefinition = "boolean default false")
    private boolean status;

    private Long jumlah;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_transaksi", referencedColumnName = "id_transaksi")
    @JsonIgnoreProperties({"peminjamans", "transaksi"})
    private Transaksi transaksi;

}
