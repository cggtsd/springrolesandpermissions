package cgg.springrolesandperm.springrolesandpermissions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cgg.springrolesandperm.springrolesandpermissions.models.User;
import java.util.List;


public interface UserRepository  extends JpaRepository<User,Integer>{
    User findByEmail(String email);
}
