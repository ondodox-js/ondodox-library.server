package com.ondodox.ondodoxlibrary.models.entities;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Table(name = "Bukus")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Buku {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_buku", nullable = false)
    private Long id;

    @NotNull
    private String judul;

    @NotNull
    private String pengarang;

    @NotNull
    private String penerbit;

    @NotNull
    private String tahunTerbit;

    @Column(columnDefinition = "boolean default false")
    private boolean status;

    @NotNull
    private Long stok;

    @Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date tanggal;

    private String gambar;

    @Lob
    @NotNull
    private String sinopsis;

    @ManyToOne()
    @JsonIgnoreProperties({"bukus"})
    @JoinColumn(name = "id_kontributor")
    private Kontributor kontributor;

    public String bodyEmailRilis(){
        return "<div\n" +
                "                      style='\n" +
                "                        width: 70%;\n" +
                "                        padding: 2em;\n" +
                "                        font-family: Arial, Helvetica, sans-serif;\n" +
                "                        margin: auto;\n" +
                "                        background-color: rgba(0, 0, 0, 0.05);\n" +
                "                        border-radius: 0.5em;\n" +
                "                      '\n" +
                "                    >\n" +
                "                      <span style='font-weight: bold; font-size: 1.5rem'>Hore!</span>\n" +
                "                      <div>\n" +
                "                        <span\n" +
                "                          >Selamat!, buku yang berjudul\n" +
                "                          <span style='font-weight: bold'>" + judul +"</span> milik anda sudah\n" +
                "                          dirilis!</span\n" +
                "                        >\n" +
                "                      </div>\n" +
                "                    </div>";
    }
}
