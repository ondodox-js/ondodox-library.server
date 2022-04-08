package com.ondodox.ondodoxlibrary.helpers;

import com.ondodox.ondodoxlibrary.dto.BukuData;
import com.ondodox.ondodoxlibrary.dto.PeminjamanData;
import com.ondodox.ondodoxlibrary.dto.TransaksiData;
import com.ondodox.ondodoxlibrary.models.entities.*;

import java.util.Date;

public class DataToEntity {
    public static Buku buku(BukuData data){
        Buku buku = new Buku();
        Kontributor kontributor = new Kontributor();
        kontributor.setId(data.getIdKontributor());
        buku.setJudul(data.getJudul());
        buku.setPenerbit(data.getPenerbit());
        buku.setPengarang(data.getPengarang());
        buku.setSinopsis(data.getSinopsis());
        buku.setStok(data.getStok());
        buku.setGambar(data.getNamaGambar());
        buku.setKontributor(kontributor);
        buku.setTahunTerbit(data.getTahunTerbit());
        return buku;
    }

    public static Transaksi transaksi(TransaksiData data){
        Transaksi transaksi = new Transaksi();
        Pengguna pengguna = new Pengguna();

        pengguna.setId(data.getIdPengguna());

        transaksi.setTotalPembayaran(data.getTotalPembayaran());
        transaksi.setPengguna(pengguna);
        return transaksi;
    }

    public static Peminjaman peminjaman(PeminjamanData data, Transaksi transaksi){
        Peminjaman peminjaman = new Peminjaman();

        Buku buku = new Buku();
        buku.setId(data.getIdBuku());

        peminjaman.setBuku(buku);
        peminjaman.setJumlah(data.getJumlah());
        peminjaman.setTanggalKembali(data.getTanggalKembali());
        peminjaman.setTransaksi(transaksi);

        return peminjaman;
    }
}
