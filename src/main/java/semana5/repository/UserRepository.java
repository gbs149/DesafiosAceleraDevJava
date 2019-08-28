package semana5.repository;

import com.challenge.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    @Query("select u from User u " +
            "inner join u.candidates c " +
            "inner join c.id.acceleration a " +
            "where a.name = :name")
    List<User> findByAccelerationName(String name);

    @Query("select u from User u " +
            "inner join u.candidates c " +
            "inner join c.id.company co " +
            "where co.id = :companyId")
    List<User> findByCompanyId(Long companyId);

}
