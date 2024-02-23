/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package haladesign.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Phương Thảo
 */
@Entity //thực thể
@Table(name = "KhachHang") //thêm bảng
@AllArgsConstructor //đầy đủ tham số
@NoArgsConstructor //k tham số
@Getter
@Setter

public class KhachHang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "ho_ten")
    private String ho_ten;
    @Column(name = "so_dien_thoai")
    private String so_dien_thoai;
    @Column(name = "email")
    private String email;
    @Column(name = "diaChi")
    private String diaChi;
    @Column(name = "ngay_tao")
    private Date ngay_tao;
    @Column(name = "ngay_sua")
    private Date ngay_sua;
    @Column(name = "xoa_mem")
    private int xoa_mem;
    @Column(name = "gioi_tinh")
    private Boolean gioi_tinh;

    @OneToMany(mappedBy = "khachHang",  cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<JPAHoaDon> listHoaDon = new ArrayList<>();
}
