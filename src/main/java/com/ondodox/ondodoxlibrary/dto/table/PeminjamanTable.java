package com.ondodox.ondodoxlibrary.dto.table;

import com.ondodox.ondodoxlibrary.models.entities.Peminjaman;
import lombok.Data;

import java.sql.Date;

@Data
public class PeminjamanTable {
    private Long idPeminjaman;
    private Long jumlah;
    private boolean status;
    private Date tanggalKembali;
    private Long idBuku;

    public PeminjamanTable(Peminjaman peminjaman) {
        idPeminjaman = peminjaman.getId();
        jumlah = peminjaman.getJumlah();
        status = peminjaman.isStatus();
        tanggalKembali = peminjaman.getTanggalKembali();
        idBuku = peminjaman.getBuku().getId();
    }
}
