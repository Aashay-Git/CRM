package org.crm.service;

import org.crm.model.User;
import org.crm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    public String addUser(User user){
        User u = new User();
        u.setUserName(user.getUsername());
        u.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(u);
        return "User added Successfully";
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUserName(username).orElseThrow(()-> new UsernameNotFoundException("User not found"));
    }
}
