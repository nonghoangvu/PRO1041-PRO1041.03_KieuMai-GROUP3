/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package haladesign.repository;

import haladesign.model.JPAHoaDon;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author NONG HOANG VU
 */
public interface IHoaDon extends JpaRepository<JPAHoaDon, Integer>{
    @Query("SELECT h FROM JPAHoaDon h WHERE h.khachHang.id = :khachHangId")
    public List<JPAHoaDon> findByKhachHangId(@Param("khachHangId") Integer khachHangId);
}
