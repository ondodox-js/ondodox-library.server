package com.ondodox.ondodoxlibrary.dto.table;

import com.ondodox.ondodoxlibrary.models.entities.Buku;
import lombok.Data;

@Data
public class BukuTable {
    private Long idBuku;
    private String gambar;
    private String judul;
    private String penerbit;
    private String pengarang;
    private String sinopsis;
    private boolean status;
    private String tahunTerbit;
    private Long idKontributor;

    public BukuTable(Buku buku) {
        idBuku = buku.getId();
        gambar = buku.getGambar();
        judul = buku.getJudul();
        penerbit = buku.getPenerbit();
        pengarang = buku.getPengarang();
        sinopsis = buku.getSinopsis();
        status = buku.isStatus();
        tahunTerbit = buku.getTahunTerbit();
        idKontributor = buku.getKontributor().getId();
    }
}
