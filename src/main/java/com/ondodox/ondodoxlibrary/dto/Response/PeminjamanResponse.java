package com.ondodox.ondodoxlibrary.dto.Response;

import com.ondodox.ondodoxlibrary.models.entities.Peminjaman;
import lombok.Data;

import java.sql.Date;

@Data
public class PeminjamanResponse {
    private Long idPeminjaman;
    private Long jumlah;
    private boolean status;
    private Date tanggalKembali;
    private BukuResponse buku;
    private Long idTransaksi;

    public PeminjamanResponse(Peminjaman peminjaman) {
        idPeminjaman = peminjaman.getId();
        jumlah = peminjaman.getJumlah();
        status = peminjaman.isStatus();
        tanggalKembali = peminjaman.getTanggalKembali();
        buku = new BukuResponse(peminjaman.getBuku());
    }
}
