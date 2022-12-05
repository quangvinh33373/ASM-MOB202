package com.vinhnqph29776.asm.object;

public class ObjKC{
    int id;
    String khoanthu_id;
    String tenkhoan,ngaythu,loaithu,sotien,noidung,hoten;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKhoanthu_id() {
        return khoanthu_id;
    }

    public void setKhoanthu_id(String khoanthu_id) {
        this.khoanthu_id = khoanthu_id;
    }

    public String getTenkhoan() {
        return tenkhoan;
    }

    public void setTenkhoan(String tenkhoan) {
        this.tenkhoan = tenkhoan;
    }

    public String getNgaythu() {
        return ngaythu;
    }

    public void setNgaythu(String ngaythu) {
        this.ngaythu = ngaythu;
    }

    public String getLoaithu() {
        return loaithu;
    }

    public void setLoaithu(String loaithu) {
        this.loaithu = loaithu;
    }

    public String getSotien() {
        return sotien;
    }

    public void setSotien(String sotien) {
        this.sotien = sotien;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public ObjKC(int id, String khoanthu_id, String tenkhoan, String ngaythu, String loaithu, String sotien, String noidung, String hoten) {
        this.id = id;
        this.khoanthu_id = khoanthu_id;
        this.tenkhoan = tenkhoan;
        this.ngaythu = ngaythu;
        this.loaithu = loaithu;
        this.sotien = sotien;
        this.noidung = noidung;
        this.hoten = hoten;
    }

    public ObjKC() {
    }
}
