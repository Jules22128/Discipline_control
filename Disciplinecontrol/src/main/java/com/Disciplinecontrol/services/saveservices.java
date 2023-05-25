package com.Disciplinecontrol.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.Disciplinecontrol.models.Models;
import com.Disciplinecontrol.models.signup;
import com.Disciplinecontrol.repositorys.Disciplines;
import com.Disciplinecontrol.repositorys.repositorys;



@Service
public class saveservices implements save{
	
	@Autowired
	private repositorys disciplinecontrol;
	
	@Autowired
	private Disciplines disciplines;

	@Override
	public Models saveDisciplinecontrol(Models student) {
		// TODO Auto-generated method stub
		return disciplinecontrol.save(student);
	}

	@Override
	public List<Models> getAllstudent() {
		// TODO Auto-generated method stub
		return disciplinecontrol.findAll();
	}

	@Override
	public Models modifyUser(Models Models) {
		// TODO Auto-generated method stub
		Models existingUser = disciplinecontrol.findById(Models.getId()).get();
		existingUser.setFname(Models.getFname());
		existingUser.setLname(Models.getLname());
		existingUser.setSex(Models.getSex());
		existingUser.setClasses(Models.getClasses());
		existingUser.setProvince(Models.getProvince());
		existingUser.setPnumber(Models.getPnumber());
		existingUser.setProfilepicture(Models.getProfilepicture());
		
        Models updatedUser = disciplinecontrol.save(existingUser);
		return updatedUser;
		
	}



	@Override
	public Page<Models> getPaginated(int pageNo, int pageSize) {
		PageRequest pageable= PageRequest.of(pageNo-1,pageSize);
		return this.disciplinecontrol.findAll(pageable);
	}

	@Override
	public signup ControlDispline(signup account) {
		// TODO Auto-generated method stub
		return disciplinecontrol.save(account);
	}



}
