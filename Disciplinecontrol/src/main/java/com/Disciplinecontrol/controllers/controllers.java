package com.Disciplinecontrol.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Disciplinecontrol.models.Models;
import com.Disciplinecontrol.models.signup;
import com.Disciplinecontrol.repositorys.Disciplines;
import com.Disciplinecontrol.repositorys.repositorys;
import com.Disciplinecontrol.services.save;
import com.Disciplinecontrol.services.saveservices;


public class controllers {
	
	@Autowired
	private save save;
	@Autowired
	private Disciplines disciplines;
	@Autowired
	private repositorys disciplinecontrol;
	@RequestMapping("/")
	public String home() {
		
		return "Information";
	}
	@RequestMapping("/Login")
	public String Login() {
		
		return "Login";
	}
	
	@RequestMapping("/save")
	public String ControlDispline(@RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname, @RequestParam("sex") String sex, @RequestParam("classes") String classes, @RequestParam("province") String province, @RequestParam("pnumber") String pnumber, @RequestParam("profilepicture") String profilepicture) {
		
		Models studentusers=new Models();
		studentusers.setFname(firstname);
		studentusers.setLname(lastname);
		studentusers.setSex(sex);
		studentusers.setClasses(classes);
		studentusers.setProvince(province);
		studentusers.setPnumber(pnumber);
		studentusers.setProfilepicture(profilepicture);
	    save.saveDisciplinecontrol(studentusers);
	    return "redirect:/view";
		
	}
	
	@GetMapping("/edit/{id}")
    public ModelAndView showModifyForm(@PathVariable("id") Integer id) {
        
        Optional<Models> user = disciplinecontrol.findById(id);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("update");
        mav.addObject("allusers",user);

        return mav;
    }
	@RequestMapping("/view")
    public  ModelAndView homeafter(){
		return PageShow(1);
    }
	@PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") String id,Models user) {
        Models userAttributes=new Models();
        userAttributes.setId(user.getId());
        userAttributes.setFname(user.getFname());
        userAttributes.setLname(user.getLname());
        userAttributes.setSex(user.getSex());
        userAttributes.setClasses(user.getClasses());
        userAttributes.setProvince(user.getProvince());
        userAttributes.setPnumber(user.getPnumber());
        Models updatedUser = save.modifyUser(userAttributes);
        return "redirect:/view";
    }
	@GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {
        Models user = disciplinecontrol.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        disciplinecontrol.delete(user);
        return "redirect:/view";
    }
	@RequestMapping("/verification")
	public String ControlDispline (@RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("confurmpassword") String confurmpassword) {
		signup newstudent=new signup();
		newstudent.setEmail(email);
		newstudent.setPassword(password);
		newstudent.setConfurmpassword(confurmpassword);
		save.ControlDispline(newstudent);
		return "login";
	}
	@RequestMapping("/loginaction")
	public String ControlDispline(@RequestParam("email") String email, @RequestParam("password") String password) {
	signup user = null;
	
	try {
		user = disciplinecontrol.findByEmail(email);
				
	}catch (Exception e) {
		System.out.println(e);
	}
	if(user!=null &&(user.getEmail().equals(email)&& user.getPassword().equals(password))) {
		return "Information";

		}else{
			return "Login";
		}
	}
	@GetMapping("/page/{pageNo}")
    public  ModelAndView PageShow(@PathVariable (value = "pageNo") int pageNo){
        ModelAndView mav=new ModelAndView();
        int pageSize=5;
        Page<Models> page=save.getPaginated(pageNo,pageSize);
        List<Models> allusersdata=page.getContent();
        mav.setViewName("Viewrecord");
        mav.addObject("currentPage",pageNo);
        mav.addObject("totalPages",page.getTotalPages());
        mav.addObject("totalItems",page.getTotalElements());
        mav.addObject("displayAll",allusersdata);
        return  mav;
    }
}
