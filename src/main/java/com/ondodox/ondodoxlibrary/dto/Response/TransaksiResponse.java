package com.ondodox.ondodoxlibrary.dto.Response;

import com.ondodox.ondodoxlibrary.dto.table.PeminjamanTable;
import com.ondodox.ondodoxlibrary.models.entities.Peminjaman;
import com.ondodox.ondodoxlibrary.models.entities.Pengguna;
import com.ondodox.ondodoxlibrary.models.entities.Transaksi;
import lombok.Data;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
public class TransaksiResponse {
    private Long idTransaksi;
    private boolean status;
    private Date tanggalTransaksi;
    private Long totalPembayaran;
    private Pengguna pengguna;
    private List<PeminjamanResponse> peminjamans = new ArrayList<>();

    public TransaksiResponse(Transaksi transaksi) {
        idTransaksi = transaksi.getId();
        status = transaksi.isStatus();
        tanggalTransaksi = transaksi.getTanggalTransaksi();
        totalPembayaran = transaksi.getTotalPembayaran();

        for (Peminjaman peminjaman : transaksi.getPeminjamans()){
            peminjamans.add(new PeminjamanResponse(peminjaman));
        }
    }
}
