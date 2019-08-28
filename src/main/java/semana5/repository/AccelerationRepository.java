package semana5.repository;

import com.challenge.entity.Acceleration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccelerationRepository extends CrudRepository<Acceleration, Long> {

    @Query("select a from Acceleration a " +
            "inner join a.candidates c " +
            "where c.id.company.id = :companyId")
    List<Acceleration> findByCompanyId(Long companyId);
}
