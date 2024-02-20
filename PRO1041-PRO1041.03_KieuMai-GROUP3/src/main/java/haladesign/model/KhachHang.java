/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package haladesign.model;

/**
 *
 * @author ADMIN
 */
public class KhachHang {
    private int id;
    private String hoTen;

    public KhachHang() {
    }

    public KhachHang(int id, String hoTen) {
        this.id = id;
        this.hoTen = hoTen;
    }

    public KhachHang(int id) {
        this.id = id;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
}
