package persistence.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.EventListener;

@Entity
@EntityListeners(EventListener.class)
@Getter
@Setter
public class Submission {
    @JoinColumn(name = "id")
    @EmbeddedId
    private User user;

    @JoinColumn(name = "id")
    @EmbeddedId
    private Challenge challenge;

    @NotNull
    private float score;

    @Column(name = "created_at")
    @CreatedDate
    private Timestamp createdAt;
}
