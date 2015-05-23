package th.co.geniustree.advisor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import th.co.geniustree.advisor.repository.UserRepository;

/**
 * @author pramoth
 */
@Service
public class CustomUserDetailService implements UserDetailsService{
    @Autowired
    private UserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findOne(username);
    }
    
}