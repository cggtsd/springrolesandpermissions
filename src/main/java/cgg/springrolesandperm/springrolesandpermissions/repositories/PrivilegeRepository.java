package cgg.springrolesandperm.springrolesandpermissions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cgg.springrolesandperm.springrolesandpermissions.models.Privilege;
import cgg.springrolesandperm.springrolesandpermissions.models.User;
import java.util.List;


public interface PrivilegeRepository  extends JpaRepository<Privilege,Integer> {
    
    Privilege findByName(String name);
}
