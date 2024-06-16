package com.example.bizam.Model;

public class Kullanici {
    private String kullaniciEmail,kullaniciId;

    public Kullanici(String kullaniciEmail,String kullaniciId) {
        this.kullaniciEmail = kullaniciEmail;
        this.kullaniciId=kullaniciId;
    }

    public Kullanici() {
    }

    public String getKullaniciEmail() {
        return kullaniciEmail;
    }

    public void setKullaniciEmail(String kullaniciEmail) {
        this.kullaniciEmail = kullaniciEmail;
    }

    public String getKullaniciId() {
        return kullaniciId;
    }

    public void setKullaniciId(String kullaniciId) {
        this.kullaniciId = kullaniciId;
    }
}
