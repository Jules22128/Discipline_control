package com.Disciplinecontrol.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.Disciplinecontrol.models.Models;
import com.Disciplinecontrol.models.signup;




public interface save {
public Models saveDisciplinecontrol(Models Models);
	
	public List<Models> getAllstudent();
	public Models modifyUser(Models Models);
	public signup ControlDispline(signup account);
	public Page<Models> getPaginated(int pageNo,int pageSize);

}
