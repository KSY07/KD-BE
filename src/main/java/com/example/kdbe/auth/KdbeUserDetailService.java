package com.example.kdbe.auth;

import com.example.kdbe.Repository.UserRepository;
import com.example.kdbe.model.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RequiredArgsConstructor
public class KdbeUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findUserByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found >> " + username));

        KdbeUserDetail kdbeUserDetail = new KdbeUserDetail();

        kdbeUserDetail.setUserId(user.getUserId());
        kdbeUserDetail.setEmail(user.getEmail());
        kdbeUserDetail.setName(user.getName());
        kdbeUserDetail.setCredential(user.getCredential());



        return kdbeUserDetail;
    }
}
