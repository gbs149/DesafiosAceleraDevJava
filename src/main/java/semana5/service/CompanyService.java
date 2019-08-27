package semana5.service;

import com.challenge.entity.Company;
import com.challenge.service.interfaces.CompanyServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService implements CompanyServiceInterface {
    @Override
    public Optional<Company> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Company> findByAccelerationId(Long accelerationId) {
        return null;
    }

    @Override
    public List<Company> findByUserId(Long userId) {
        return null;
    }

    @Override
    public Company save(Company object) {
        return null;
    }
}
