/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package haladesign.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "QuyenHan")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class QuyenHan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "ten_quyen_han")
    private String roleName;
    
    @Column(name = "nhin_gia_von")
    private int canViewOrginalPrice;
    
    @Column(name = "nhap_kho")
    private int canAddProduct;
    
    @Column(name = "huy_don_hang")
    private int canChangeBillState;
    
    @Column(name = "sua_tt_khach_hang")
    private int canChangeCustomerInfo;
    
    @Column(name = "xem_bao_cao")
    private int canViewDashboard;

    @Override
    public String toString() {
        return roleName;
    }

    
}
