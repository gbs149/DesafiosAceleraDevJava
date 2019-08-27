package semana5.service;

import com.challenge.entity.Challenge;
import com.challenge.service.interfaces.ChallengeServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChallengeService implements ChallengeServiceInterface {
    @Override
    public List<Challenge> findByAccelerationIdAndUserId(Long accelerationId, Long userId) {
        return null;
    }

    @Override
    public Challenge save(Challenge object) {
        return null;
    }
}
