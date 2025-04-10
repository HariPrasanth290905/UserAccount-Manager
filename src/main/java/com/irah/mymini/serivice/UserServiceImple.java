package com.irah.mymini.serivice;

import com.irah.mymini.inter.UserService;
import com.irah.mymini.model.Users;
import com.irah.mymini.userrepo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImple implements UserService {

    @Autowired
    UserRepository repo;


    @Override
    public String createOrUpdateUser(Users user) {
       repo.save(user);
       if(user.getId()==null) {
           user.setActive("Y");
           return "User created";
       }
       else
           return "User updated";
    }

    @Override
    public List<Users> getAllUsers() {
        return repo.findAll();
    }

    @Override
    public Users getUser(int id) {
        return (repo.findById(id).isPresent())?repo.findById(id).get():null;
    }

    @Override
    public boolean deleteUser(int id) {
        boolean b = repo.existsById(id);
        if (b) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateStatus(String status, int id) {
        try {
            repo.updateStatus(status, id);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
