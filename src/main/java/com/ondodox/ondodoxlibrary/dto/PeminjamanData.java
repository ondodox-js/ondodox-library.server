package com.ondodox.ondodoxlibrary.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class PeminjamanData {
    private Long jumlah;
    private Date tanggalKembali;
    private Long idBuku;
}
