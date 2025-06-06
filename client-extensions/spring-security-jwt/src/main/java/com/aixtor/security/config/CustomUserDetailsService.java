package com.aixtor.security.config;

import com.aixtor.security.model.User;
import com.aixtor.security.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         User user=userRepo.findByEmail(username).orElse(null);
         if (user==null){

             throw new UsernameNotFoundException("user not found");
         }
        return new CustomUserDetails(user);
    }
}
