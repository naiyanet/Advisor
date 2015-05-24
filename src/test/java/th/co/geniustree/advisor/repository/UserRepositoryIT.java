package th.co.geniustree.advisor.repository;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import th.co.geniustree.advisor.AdvisorApplication;
import th.co.geniustree.advisor.domain.User;


/**
 *
 * @author pramoth
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AdvisorApplication.class)
@Transactional
public class UserRepositoryIT {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void savedUserMustFound() {
        User user = new User();
        user.setEmail("xxxx");
        userRepository.save(user);
        User findOne = userRepository.findOne("xxxx");
        Assertions.assertThat(findOne).isNotNull();
    }

}
