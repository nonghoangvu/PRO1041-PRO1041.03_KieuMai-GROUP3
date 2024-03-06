package haladesign.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Nong Hoang Vu
 */
@Entity
@Table(name = "Account")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @Column(name = "ho_ten")
    private String fullName;

    @Column(name = "sdt")
    private String phoneNum;

    @Column(name = "email")
    private String email;

    @Column(name = "gioi_tinh")
    private Boolean gender;

    @Column(name = "ngay_sinh")
    private String birthdate;

    @Column(name = "mat_khau")
    private String password;

    @Column(name = "ngay_tao")
    private Date createdDate;

    @Column(name = "trang_thai")
    private String userState;

    @Column(name = "ghi_chu")
    private String note;
}
