package com.ondodox.ondodoxlibrary.dto.Response;

import com.ondodox.ondodoxlibrary.models.entities.Kontributor;
import lombok.Data;

@Data
public class KontributorResponse {
    private Long idKontributor;
    private String email;
    private String kataSandi;
    private String namaLengkap;
    private boolean status;

    public KontributorResponse(Kontributor kontributor) {
        idKontributor = kontributor.getId();
        email = kontributor.getEmail();
        kataSandi = kontributor.getKataSandi();
        namaLengkap = kontributor.getNamaLengkap();
        status = kontributor.isStatus();
    }
}
