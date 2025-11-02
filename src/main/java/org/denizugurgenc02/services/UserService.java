package org.denizugurgenc02.services;

import org.denizugurgenc02.entities.User;
import org.denizugurgenc02.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService{
    @Autowired
    private IUserRepository userRepository;

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User getUser(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public Boolean deleteUser(Integer id) {
        if (!userRepository.existsById(id)) {
            return false;
        }
        userRepository.deleteById(id);
        return true;
    }

    public User updateUser(Integer id, User user) {
        User updatedUser = userRepository.findById(id).orElse(null);
        if (updatedUser != null) {
            updatedUser.setUsername(user.getUsername());
            updatedUser.setPassword(user.getPassword());
            updatedUser.setEmail(user.getEmail());
            updatedUser.setFirstName(user.getFirstName());
            updatedUser.setLastName(user.getLastName());
            return userRepository.save(updatedUser);
        }
        return null;
    }

    public List<User> getUserList() {
        return userRepository.findAll();
    }
}
