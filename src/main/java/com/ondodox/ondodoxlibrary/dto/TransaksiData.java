package com.ondodox.ondodoxlibrary.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TransaksiData {
    private Long totalPembayaran;
    private Long idPengguna;
    private List<PeminjamanData> peminjamans = new ArrayList<>();
}
