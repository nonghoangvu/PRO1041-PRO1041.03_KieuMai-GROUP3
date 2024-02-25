package haladesign.repository;

import haladesign.model.ChatLieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author NONG HOANG VU
 */
public interface IChatLieu extends JpaRepository<ChatLieu, Integer> {

    @Query("SELECT cl FROM ChatLieu cl WHERE cl.loaiChatLieu = :loaiChatLieu")
    public ChatLieu findByLoaiChatLieu(@Param("loaiChatLieu") String loaiChatLieu);
}
