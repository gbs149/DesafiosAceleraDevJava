package semana5.service;

import com.challenge.entity.Submission;
import com.challenge.service.interfaces.SubmissionServiceInterface;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class SubmissionService implements SubmissionServiceInterface {
    @Override
    public BigDecimal findHigherScoreByChallengeId(Long challengeId) {
        return null;
    }

    @Override
    public List<Submission> findByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId) {
        return null;
    }

    @Override
    public Submission save(Submission object) {
        return null;
    }
}
