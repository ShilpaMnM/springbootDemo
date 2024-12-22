package com.firstApp.FirstApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.firstApp.FirstApp.entity.User;
import com.firstApp.FirstApp.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> fetchUserList() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User updateUser(User user, Long userId) {
        Optional<User> userDB = userRepository.findById(userId);

        if (userDB.isPresent()) {
            User userToUpdate = userDB.get();

            if (Objects.nonNull(user.getFirstName()) && !"".equalsIgnoreCase(user.getFirstName())) {
                userToUpdate.setFirstName(user.getFirstName());
            }

            if (Objects.nonNull(user.getLastName()) && !"".equalsIgnoreCase(user.getLastName())) {
                userToUpdate.setLastName(user.getLastName());
            }

            if (Objects.nonNull(user.getEmail()) && !"".equalsIgnoreCase(user.getEmail())) {
                userToUpdate.setEmail(user.getEmail());
            }

            if (Objects.nonNull(user.getPhoneNumber()) && !"".equalsIgnoreCase(user.getPhoneNumber())) {
                userToUpdate.setPhoneNumber(user.getPhoneNumber());
            }

            if (Objects.nonNull(user.getAddress()) && !"".equalsIgnoreCase(user.getAddress())) {
                userToUpdate.setAddress(user.getAddress());
            }

            if (Objects.nonNull(user.getCity()) && !"".equalsIgnoreCase(user.getCity())) {
                userToUpdate.setCity(user.getCity());
            }

            if (Objects.nonNull(user.getState()) && !"".equalsIgnoreCase(user.getState())) {
                userToUpdate.setState(user.getState());
            }

            if (Objects.nonNull(user.getPostalCode()) && !"".equalsIgnoreCase(user.getPostalCode())) {
                userToUpdate.setPostalCode(user.getPostalCode());
            }

            if (Objects.nonNull(user.getCountry()) && !"".equalsIgnoreCase(user.getCountry())) {
                userToUpdate.setCountry(user.getCountry());
            }

            if (Objects.nonNull(user.getDateOfBirth())) {
                userToUpdate.setDateOfBirth(user.getDateOfBirth());
            }

            return userRepository.save(userToUpdate);
        } else {
            throw new RuntimeException("User not found with id: " + userId);
        }
    }

    @Override
    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }
}

