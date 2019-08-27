package semana5.service;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
import com.challenge.service.interfaces.CandidateServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateService implements CandidateServiceInterface {
    @Override
    public Optional<Candidate> findById(CandidateId id) {
        return Optional.empty();
    }

    @Override
    public Optional<Candidate> findById(Long userId, Long companyId, Long accelerationId) {
        return Optional.empty();
    }

    @Override
    public List<Candidate> findByCompanyId(Long companyId) {
        return null;
    }

    @Override
    public List<Candidate> findByAccelerationId(Long accelerationId) {
        return null;
    }

    @Override
    public Candidate save(Candidate object) {
        return null;
    }
}
