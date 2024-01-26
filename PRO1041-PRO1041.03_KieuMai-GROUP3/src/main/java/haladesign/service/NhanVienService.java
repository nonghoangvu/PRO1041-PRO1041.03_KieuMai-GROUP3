/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package haladesign.service;

import haladesign.model.NhanVien;
import haladesign.repository.INhanVien;
import java.util.List;
import static haladesign.Application.getBean;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 * @author Administrator
 */
public class NhanVienService {

    private final INhanVien iNhanVien = getBean(INhanVien.class);

    public List<NhanVien> getList() {
        return iNhanVien.findAll().stream()
                .filter(employee -> !employee.getUserState().equalsIgnoreCase("deleted"))
                .collect(Collectors.toList());
    }

    public boolean addNewNhanVien(NhanVien nhanVien) {
        return this.iNhanVien.save(nhanVien) != null;
    }

    public NhanVien getEmplLogin(String phoneNumber) {
        return iNhanVien.findBySdtAndNotDeleted(phoneNumber);
    }

}
