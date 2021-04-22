package com.pack.SpringBootRoleBasedSecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.SpringBootRoleBasedSecurity.model.Leave;
import com.pack.SpringBootRoleBasedSecurity.repository.LeaveRepository;

@Service
public class LeaveServiceImpl implements LeaveService{
	@Autowired
	private LeaveRepository leaveRepository;

	@Override
	public void saveLeave(Leave leave) {
		leave.setStatus("Pending");
		leaveRepository.save(leave);
		
	}

	@Override
	public List<Leave> fetchAllLeaves() {
		List<Leave> list=leaveRepository.findAll();
		return list;
		
	}

	@Override
	public Leave getLeaveById(long id) {
		Leave leav=leaveRepository.getOne(id);
		return leav;
	}

	@Override
	public void updateLeave(Leave leave) {
		leave.setStatus("Approved");
		leaveRepository.save(leave);
		
	}

	@Override
	public void deleteLeave(long id) {
		leaveRepository.deleteById(id);
		
	}

	@Override
	public Leave getLeaveId(long id) {
		return leaveRepository.getOne(id);
	}

}
