package persistence.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

@Entity
@EntityListeners(EventListener.class)
@Embeddable
@Getter
@Setter
public class Challenge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(max = 100)
    private String name;

    @NotNull
    @Size(max = 50)
    private String slug;

    @Column(name = "created_at")
    @CreatedDate
    private Timestamp createdAt;

    @OneToMany
    List<Acceleration> accelerations = new ArrayList<>();

    @OneToMany
    List<Submission> submissions = new ArrayList<>();

}
