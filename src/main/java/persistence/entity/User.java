package persistence.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.Email;
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
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "full_name")
    @NotNull
    @Size(max = 100)
    private String fullName;

    @Email
    @NotNull
    @Size(max = 100)
    private String email;

    @NotNull
    @Size(max = 50)
    private String nickname;

    @NotNull
    @Size(max = 255)
    private String password;

    @Column(name = "created_at")
    @CreatedDate
    private Timestamp createdAt;

    @OneToMany()
    private List<Candidate> candidates = new ArrayList<>();

    @OneToMany
    List<Submission> submissions = new ArrayList<>();
}
