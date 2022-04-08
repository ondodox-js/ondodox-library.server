package com.ondodox.ondodoxlibrary.dto;

import lombok.Data;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class BukuData {
    @NotNull
    private String judul;

    @NotNull
    private String pengarang;

    @NotNull
    private String penerbit;

    @NotNull
    private String tahunTerbit;

    @NotNull
    private Long stok;

    @NotNull
    private MultipartFile gambar;

    @NotNull
    @Lob
    private String sinopsis;

    @NotNull
    private Long idKontributor;

    public String getNamaGambar(){
        String gambar = String.valueOf(new Date().getTime());
        gambar += "." + FilenameUtils.getExtension(this.gambar.getOriginalFilename());
        return gambar;
    }
}
