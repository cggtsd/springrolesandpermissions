package cgg.springrolesandperm.springrolesandpermissions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cgg.springrolesandperm.springrolesandpermissions.models.Role;
import cgg.springrolesandperm.springrolesandpermissions.models.User;
import java.util.List;


public interface RoleRepository  extends JpaRepository<Role,Integer> {
 
    Role findByName(String name);
}
