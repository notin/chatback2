package com.chatback.pojos.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;

@Service
public class UserService
{
    @Autowired
    private UserRepository userRepository;

    public User findUserByUId(String id)
    {
       return userRepository.findUserByUid(id);
    }

    public void saveUser(User user)
    {
        userRepository.save(user);
    }
}
