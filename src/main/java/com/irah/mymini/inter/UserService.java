package com.irah.mymini.inter;

import com.irah.mymini.model.Users;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {
    public String createOrUpdateUser(Users user);
    public List<Users> getAllUsers();
    public Users getUser(int id);
    public boolean deleteUser(int id);
    public boolean updateStatus(String status,int  id);
}
