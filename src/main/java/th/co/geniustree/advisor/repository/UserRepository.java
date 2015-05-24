package th.co.geniustree.advisor.repository;

import javax.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import th.co.geniustree.advisor.domain.User;

/**
 * @author pramoth
 */
public interface UserRepository extends JpaRepository<User, String> {

}
