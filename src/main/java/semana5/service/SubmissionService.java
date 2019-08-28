package semana5.service;

import com.challenge.entity.Submission;
import com.challenge.repository.SubmissionRepository;
import com.challenge.service.interfaces.SubmissionServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class SubmissionService implements SubmissionServiceInterface {
    @Autowired
    SubmissionRepository submissionRepository;

    @Override
    public BigDecimal findHigherScoreByChallengeId(Long challengeId) {
        return BigDecimal.valueOf(Optional.ofNullable(submissionRepository.findHigherScoreByChallengeId(challengeId))
                .orElse(0f));
    }

    @Override
    public List<Submission> findByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId) {
        return submissionRepository.findByChallengeIdAndAccelerationId(challengeId, accelerationId);
    }

    @Override
    public Submission save(Submission object) {
        return submissionRepository.save(object);
    }
}
