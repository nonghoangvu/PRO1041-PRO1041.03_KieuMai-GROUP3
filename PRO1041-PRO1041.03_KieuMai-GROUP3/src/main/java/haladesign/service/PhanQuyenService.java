/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package haladesign.service;

import static haladesign.Application.getBean;
import haladesign.model.NhanVien;
import haladesign.model.QuyenHan;
import haladesign.repository.INhanVien;
import haladesign.repository.IQuyenHan;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Administrator
 */
public class PhanQuyenService {
    private final IQuyenHan iQuyenHan = getBean(IQuyenHan.class);

    public List<QuyenHan> getList() {
        return iQuyenHan.findAll().stream().collect(Collectors.toList());
    }
}
