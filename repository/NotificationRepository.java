package vn.codegym.pig_farm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.codegym.pig_farm.entity.Notification;

import javax.transaction.Transactional;
import java.time.LocalDate;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {

    /**
     * Create by HuyenTN
     * Date: 08/09/2022
     * Write query create notification
     * @param id
     * @param content
     * @param submitted_date
     * @param image
     */
    @Transactional
    @Modifying
    @Query(value = "insert into notification(id, content, submitted_date, image) " +
            " values (:id, :content, :submitted_date, :image);", nativeQuery = true)
    void save(@Param("id") Integer id, @Param("content") String content,
              @Param("submitted_date") LocalDate submitted_date, @Param("image") String image);

    /**
     * Create by HuyenTN
     * Date: 08/09/2022
     * Write query edit notification
     * @param content
     * @param submittedDate
     * @param image
     * @param isDeleted
     * @param id
     */

    @Transactional
    @Modifying
    @Query(value = "update notification set content = :content, submitted_date = :submittedDate, " +
            " image = :image, is_deleted = :isDeleted where id = :id", nativeQuery = true)
    void update(@Param("content") String content, @Param("submittedDate") LocalDate submittedDate,
                @Param("image") String image, @Param("isDeleted") Boolean isDeleted, @Param("id") Integer id);
}
