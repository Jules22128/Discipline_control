package com.Disciplinecontrol.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Disciplinecontrol.models.Models;
import com.Disciplinecontrol.models.signup;


public interface repositorys extends JpaRepository<Models, Integer> {
	signup findByEmail(String email);

}
