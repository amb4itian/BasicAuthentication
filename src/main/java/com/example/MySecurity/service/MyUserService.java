package com.example.MySecurity.service;

import com.example.MySecurity.UserPrinciple;
import com.example.MySecurity.dao.UserRepo;
import com.example.MySecurity.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserService implements UserDetailsService {

    @Autowired
    UserRepo repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user = repo.findByUsername(username);
       if(null==user){
           throw new UsernameNotFoundException("404");
       }
        return new UserPrinciple(user);
    }
}
