package com.ondodox.ondodoxlibrary.dto.table;

import com.ondodox.ondodoxlibrary.dto.Response.PenggunaResponse;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
public class TransaksiTable {
    private Long idTransaksi;
    private boolean status;
    private Date tanggalTransaksi;
    private Long totalPemabayaran;
    private PenggunaResponse pengguna;
    private List<PeminjamanTable> peminjamans;
}
