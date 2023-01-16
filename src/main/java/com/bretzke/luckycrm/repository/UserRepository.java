package com.bretzke.luckycrm.repository;
import com.bretzke.luckycrm.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByEmail(String email);
    Users findByUsername(String username);
    public Users findByUsernameAndPassword(String username, String password);
}
