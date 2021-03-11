package com.example.demo.services.impl;

import com.example.demo.entities.User;
import com.example.demo.services.UserService;
import com.example.demo.services.UserServiceException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService {

    private List<User> users;
    private AtomicInteger currentId = new AtomicInteger(0);

    public UserServiceImpl(){
        this.users = new ArrayList<>();

        User a = new User();
        a.setId(Integer.toString(currentId.addAndGet(1)));
        a.setName("David");
        a.setEmail("david@example.com");
        this.users.add(a);

        User b = new User();
        b.setId(Integer.toString(currentId.addAndGet(1)));
        b.setName("Juan");
        b.setEmail("juan@example.com");
        this.users.add(b);

        User c = new User();
        c.setId(Integer.toString(currentId.addAndGet(1)));
        c.setName("Pepe");
        c.setEmail("pepe@example.com");
        this.users.add(c);

        User d = new User();
        d.setId(Integer.toString(currentId.addAndGet(1)));
        d.setName("Luis");
        d.setEmail("luis@example.com");
        this.users.add(d);
    }

    @Override
    public List<User> getAll() {
        return this.users;
    }

    @Override
    public User getById(String userId) throws UserServiceException {
        Optional<User> ans
                = this.users.stream().filter(x -> x.getId().equals(userId)).findFirst();
        if(!ans.isPresent()){
            throw new UserServiceException(UserServiceException.USER_NOT_FOUND);
        }
        return ans.get();

    }

    @Override
    public User create(User user) throws UserServiceException {
        if(user.getEmail() == null || user.getName() == null){
            throw new UserServiceException(UserServiceException.USER_NOT_DEFINED);
        }
        user.setId(Integer.toString(currentId.addAndGet(1)));
        this.users.add(user);
        return user;
    }

    @Override
    public User update(User user) throws UserServiceException {
        Optional<User> ans
                = this.users.stream().filter(x -> x.getId().equals(user.getId())).findFirst();
        if(!ans.isPresent()){
            throw new UserServiceException(UserServiceException.USER_NOT_FOUND);
        }
        User target = ans.get();
        if(user.getName()!=null){
            target.setName(user.getName());
        }
        if(user.getEmail()!=null){
            target.setEmail(user.getEmail());
        }
        return target;
    }

    @Override
    public void remove(String userId) throws UserServiceException {
        boolean removed = this.users.removeIf(x-> x.getId().equals(userId));
        if(!removed){
            throw new UserServiceException(UserServiceException.USER_NOT_FOUND);
        }
    }
}
