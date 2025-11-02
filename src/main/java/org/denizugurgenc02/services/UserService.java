package org.denizugurgenc02.services;

import org.denizugurgenc02.dto.UserRequestDTO;
import org.denizugurgenc02.dto.UserResponseDTO;
import org.denizugurgenc02.entities.User;
import org.denizugurgenc02.repository.IUserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService{
    @Autowired
    private IUserRepository userRepository;

    public UserResponseDTO addUser(UserRequestDTO request) {
        User user = new User();
        UserResponseDTO response = new UserResponseDTO();

        BeanUtils.copyProperties(request, user);
        User dbUser = userRepository.save(user);
        BeanUtils.copyProperties(dbUser, response);

        return response;
    }

    public UserResponseDTO getUser(Integer id) {
        User dbUser = userRepository.findById(id).orElse(null);
        UserResponseDTO response = new UserResponseDTO();
        if  (dbUser != null) {
            BeanUtils.copyProperties(dbUser, response);
        }
        return response;
    }

    public Boolean deleteUser(Integer id) {
        if (!userRepository.existsById(id)) {
            return false;
        }
        userRepository.deleteById(id);
        return true;
    }

    public UserResponseDTO updateUser(Integer id, UserRequestDTO user) {
        User updatedUser = userRepository.findById(id).orElse(null);
        if (updatedUser != null) {
            updatedUser.setUsername(user.getUsername());
            updatedUser.setPassword(user.getPassword());
            updatedUser.setEmail(user.getEmail());
            updatedUser.setFirstname(user.getFirstname());
            updatedUser.setLastname(user.getLastname());
            userRepository.save(updatedUser);

            UserResponseDTO response = new UserResponseDTO();
            BeanUtils.copyProperties(updatedUser, response);
            return response;
        }
        return null;
    }

    public List<UserResponseDTO> getUserList() {
        List<User> dbUserList = userRepository.findAll();
        List<UserResponseDTO> responseList = new ArrayList<>();
        for (User user : dbUserList) {
            UserResponseDTO unit = new UserResponseDTO();
            BeanUtils.copyProperties(user, unit);
            responseList.add(unit);
        }
        return responseList;
    }
}
