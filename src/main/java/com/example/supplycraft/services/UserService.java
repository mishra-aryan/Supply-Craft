package com.example.supplycraft.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.supplycraft.models.User;
import com.example.supplycraft.repositories.UserRepository;
import com.example.supplycraft.dto.UserDTO;
import com.example.supplycraft.security.CustomUserDetailsService;
import com.example.supplycraft.security.JwtTokenProvider;

import java.util.List;

import javax.persistence.EntityNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private CustomUserDetailsService userDetailsService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
    }

    public User createUser(UserDTO userDTO) {
        User user = new User();
        copyUserDtoToEntity(userDTO, user);
        encodePassword(user);
        return userRepository.save(user);
    }

    public User updateUser(Long id, UserDTO userDTO) {
        User existingUser = getUserById(id);
        copyUserDtoToEntity(userDTO, existingUser);
        return userRepository.save(existingUser);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    private void copyUserDtoToEntity(UserDTO userDTO, User user) {
 //       BeanUtils.copyProperties(userDTO, user, "id", "password");
    	BeanUtils.copyProperties(userDTO, user);
    }

    private void encodePassword(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
    }

    public String loginUser(String username, String password) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if (userDetails != null && passwordEncoder.matches(password, userDetails.getPassword())) {
            Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return jwtTokenProvider.generateToken(userDetails);
        } else {
            throw new BadCredentialsException("Invalid username or password");
        }
    }

}
