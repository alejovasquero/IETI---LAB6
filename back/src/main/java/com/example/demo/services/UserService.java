package com.example.demo.services;

import com.example.demo.entities.User;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface UserService {
    List<User> getAll();

    User getById(String userId) throws UserServiceException;

    User create(User user) throws UserServiceException;

    User update(User user) throws UserServiceException;

    void remove(String userId) throws UserServiceException;
}
