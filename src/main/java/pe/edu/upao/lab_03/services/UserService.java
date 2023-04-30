package pe.edu.upao.lab_03.services;

import pe.edu.upao.lab_03.models.User;

import java.util.List;

public interface UserService {
    User createUser(User user);

    List<User> getAllUsers();

    User getUserById(Long id);
    User getuserByUsername(String username);

    User addUser(User user);

    User updateUser(Long id, User user);
    void deleteUser(Long id);

    User register(String username, String password, String email);

    User login(String username, String password);
}