package semana5.repository;

import com.challenge.entity.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CompanyRepository extends CrudRepository<Company, Long> {
    @Query("select distinct c from Company c " +
            "inner join c.candidates ca " +
            "inner join ca.id.acceleration a " +
            "where a.id = :accelerationId")
    List<Company> findByAccelerationId(Long accelerationId);

    @Query("from Company c " +
            "left join c.candidates ca " +
            "left join ca.id.user u " +
            "where u.id = :userId")
    List<Company> findByUserId(Long userId);
}
