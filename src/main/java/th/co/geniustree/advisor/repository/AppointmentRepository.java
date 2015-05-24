package th.co.geniustree.advisor.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import th.co.geniustree.advisor.domain.Appointment;

/**
 *
 * @author User
 */
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    public Page<Appointment> findByTeacherAndStudent(String teacher, String student, Pageable pagable);

}
