package com.pack.SpringBootRoleBasedSecurity.service;

import java.util.List;

import com.pack.SpringBootRoleBasedSecurity.model.Leave;

public interface LeaveService {
	void saveLeave(Leave leave);
    List<Leave> fetchAllLeaves();
    Leave getLeaveById(long id);
    void updateLeave(Leave leave);
    void deleteLeave(long id);
	Leave getLeaveId(long id);

}
