package com.irah.mymini.userrepo;

import com.irah.mymini.model.Users;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

    @Modifying
    @Transactional
    @Query("update Users set active=:status where id=:uid")
    public void updateStatus(String status, Integer uid);
}

