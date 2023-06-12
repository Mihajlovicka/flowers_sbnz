package com.ftn.sbnz.service;

import com.ftn.sbnz.model.user.PlantCareUserForm;
import com.ftn.sbnz.model.user.User;
import com.ftn.sbnz.repository.UserPlantFormRepository;
import com.ftn.sbnz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired private UserRepository userRepository;
    @Autowired private UserPlantFormRepository userPlantFormRepository;

    public void register(User u){
        userPlantFormRepository.save(u.getPlantCareUserForm());
        userRepository.save(u);
    }

    public User login(String email, String password){
        return userRepository.findByEmailAndPassword(email,password).orElseThrow( () -> new RuntimeException("Neuspesna prijava."));
    }

    public User getByEmail(String email){
        return userRepository.findByEmail(email).orElse(null);
    }

    public void update(User u) {
        this.userRepository.save(u);
    }
}
