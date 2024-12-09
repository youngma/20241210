package musinsa.bob.main.config.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    /**
     * 등록 일자
     */
    @CreatedDate
    @Column(name = "INSERTED_AT")
    LocalDateTime insertedAt = LocalDateTime.now();

    /**
     * 등록자
     */
    @CreatedBy
    @Column(name = "INSERTED_ID")
    private String insertedId;

    /**
     * 수정 일자
     */
    @LastModifiedDate
    @Column(name = "UPDATED_AT")
    LocalDateTime updatedAt = LocalDateTime.now();

    /**
     * 수정자
     */
    @LastModifiedBy
    @Column(name = "UPDATED_ID")
    private String updatedId;

}
