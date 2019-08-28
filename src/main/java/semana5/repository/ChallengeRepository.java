package semana5.repository;

import com.challenge.entity.Challenge;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ChallengeRepository extends CrudRepository<Challenge, Long> {
    @Query("select c from Challenge c " +
            "inner join fetch Acceleration a " +
            "inner join fetch Submission s " +
            "inner join fetch User u " +
            "where a.id = :accelerationId " +
            "and u.id = :userId")
    List<Challenge> findByAccelerationIdAndUserId(Long accelerationId, Long userId);
}
