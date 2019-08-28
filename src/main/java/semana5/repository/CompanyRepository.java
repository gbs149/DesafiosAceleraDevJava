package semana5.repository;

import com.challenge.entity.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CompanyRepository extends CrudRepository<Company, Long> {
    @Query("from Company c " +
            "left join Candidate ca " +
            "left join Acceleration a " +
            "where a.id = :acceleraionId")
    List<Company> findByAccelerationId(Long accelerationId);

    @Query("from Company c " +
            "left join Candidate ca " +
            "left join User u " +
            "where u.id = :userId")
    List<Company> findByUserId(Long userId);

}
