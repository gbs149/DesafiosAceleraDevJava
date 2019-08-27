package semana5.service;

import com.challenge.entity.Acceleration;
import com.challenge.service.interfaces.AccelerationServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccelerationService implements AccelerationServiceInterface {
    @Override
    public Optional<Acceleration> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Acceleration> findByCompanyId(Long companyId) {
        return null;
    }

    @Override
    public Acceleration save(Acceleration object) {
        return null;
    }
}
