package es.neesis.security.service;

import es.neesis.security.entities.UserEntity;
import es.neesis.security.model.CustomUserDetails;
import es.neesis.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(user);
    }

    public List<UserDetails> loadAllUsers() {
        List<UserEntity> users = (List<UserEntity>) userRepository.findAll();
        List<UserDetails> userDetailsList = new ArrayList<>();
        for (UserEntity user : users) {
            userDetailsList.add(new CustomUserDetails(user));
        }
        return userDetailsList;
    }
}
