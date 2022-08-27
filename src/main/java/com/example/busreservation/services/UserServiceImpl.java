package com.example.busreservation.services;

import com.example.busreservation.model.User;
import com.example.busreservation.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepo userRepo;
    @Override
    public User addUser(User user) {
//        User foundUser=userRepo.findOneByEmail(user.getEmail());
//        if(foundUser!=null){
//            log.error("User already exists");
//        }
        User user1=new User();
        user1.setEmail(user.getEmail());
        user1.setFirstName(user.getFirstName());
        user1.setLastName(user.getLastName());
        user1.setPhoneNumber(user.getPhoneNumber());
        user1.setPassword(user.getPassword());
        user1.setActivated(false);
        user1.setWalletBalance(user.getWalletBalance());
        user1.setActivationHash(UUID.randomUUID().toString());
        user1.setRole("ROLE_USER");
        return userRepo.save(user1);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepo.findOneByEmail(email);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public void saveUser(User user) {
        log.info("Saving user {}",user);
        userRepo.save(user);
    }

    @Override
    public void updateUser(User user) {
        userRepo.save(user);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepo.deleteById(id);
    }


//    @Override
//    public User getUserById(Long id) {
//        return userRepo.findOne(id);
//    }
}
