package com.example.studycenter.web.resource;

import com.example.studycenter.domin.Users;
import com.example.studycenter.repository.UserRepository;
import com.example.studycenter.security.JwtTokenProvider;
import com.example.studycenter.web.resource.vm.LoginVM;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserJwtController {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;

    public UserJwtController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, UserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    private ResponseEntity login(@RequestBody LoginVM loginVM) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginVM.getUsername(), loginVM.getPassword()));
        Users user = userRepository.findByLogin(loginVM.getUsername());
        if (user == null) {
            throw new UsernameNotFoundException("This user does not exist");
        }
        String token = jwtTokenProvider.creatToken(user.getUserName(), user.getRoles());
        Map<Object, Object> map = new HashMap<>();
        map.put("username", user.getUserName());
        map.put("token", token);
        return ResponseEntity.ok(map);
    }
}
