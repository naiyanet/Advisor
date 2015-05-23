package th.co.geniustree.advisor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import th.co.geniustree.advisor.domain.Appointment;

/**
 *
 * @author User
 */
public interface AppointmentRepository extends JpaRepository<Appointment, Integer>{
    
}
