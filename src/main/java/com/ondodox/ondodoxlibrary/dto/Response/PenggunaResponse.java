package com.ondodox.ondodoxlibrary.dto.Response;

import com.ondodox.ondodoxlibrary.models.entities.Pengguna;
import lombok.Data;

@Data
public class PenggunaResponse {
    private Long idPengguna;
    private String email;
    private String kataSandi;
    private String namaLengkap;
    private boolean status;

    public PenggunaResponse(Pengguna pengguna) {
        idPengguna = pengguna.getId();
        email = pengguna.getEmail();
        kataSandi = pengguna.getKataSandi();
        namaLengkap = pengguna.getNamaLengkap();
        status = pengguna.isStatus();
    }
}
