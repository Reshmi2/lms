package com.pack.SpringBootRoleBasedSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pack.SpringBootRoleBasedSecurity.model.Leave;
@Repository
public interface LeaveRepository extends JpaRepository<Leave, Long>{

}
