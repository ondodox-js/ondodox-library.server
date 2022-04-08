package com.ondodox.ondodoxlibrary.dto.Response;

import com.ondodox.ondodoxlibrary.models.entities.Buku;
import lombok.Data;

import java.time.Year;

@Data
public class BukuResponse {
    private Long idBuku;
    private String gambar;
    private String judul;
    private String penerbit;
    private String pengarang;
    private String sinopsis;
    private boolean status;
    private String tahunTerbit;
    private KontributorResponse kontributor;

    public BukuResponse(Buku buku) {
        idBuku = buku.getId();
        gambar = buku.getGambar();
        judul = buku.getJudul();
        penerbit = buku.getPenerbit();
        pengarang = buku.getPengarang();
        sinopsis = buku.getSinopsis();
        status = buku.isStatus();
        tahunTerbit = buku.getTahunTerbit();
        kontributor = new KontributorResponse(buku.getKontributor());
    }
}
