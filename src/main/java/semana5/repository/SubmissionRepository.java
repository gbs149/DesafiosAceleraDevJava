package semana5.repository;

import com.challenge.entity.Submission;
import com.challenge.entity.SubmissionId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SubmissionRepository extends CrudRepository<Submission, SubmissionId> {


    @Query("select max(s.score) from Submission s " +
            "where s.id.challenge.id = :challengeId ")
    Float findHigherScoreByChallengeId(Long challengeId);

    @Query("select s from Submission s " +
            "inner join s.id.challenge c " +
            "inner join c.accelerations a " +
            "where c.id = :challengeId and a.id = :accelerationId")
    List<Submission> findByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId);

}
