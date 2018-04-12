package com.example.rpl88.wallezz;

/**
 * Created by rpl88 on 12/04/18.
 */

public class Biodata {
    String nama;
    String alamat;

    public Biodata(String nama, String alamat) {
        this.nama = nama;
        this.alamat = alamat;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
