package semana5.repository;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CandidateRepository extends CrudRepository<Candidate, CandidateId> {
    Optional<Candidate> findById_User_IdAndId_Company_IdAndId_Acceleration_Id(Long userId, Long companyId, Long accelerationId);

    List<Candidate> findById_Company_Id(Long companyId);

    List<Candidate> findById_Acceleration_Id(Long accelerationId);
}
