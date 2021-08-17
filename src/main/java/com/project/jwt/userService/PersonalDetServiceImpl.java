package com.project.jwt.userService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.jwt.Dao.PersonalDetailsDao;
import com.project.jwt.Entities.PersonalDetails;
import com.project.jwt.serviceInterface.PersonalDetService;

@Service
public class PersonalDetServiceImpl implements PersonalDetService {
	@Autowired
	private PersonalDetailsDao personaldetdao;
	
	public void savedetails(PersonalDetails personaldet) throws Exception  {
		
		if(personaldet.getId()==0) {
			throw new Exception("Invalid ID");
		}
		if(personaldet.getFirstname().length()<=2) {
			throw new Exception("Invalid Firstname");
		}
		if(personaldet.getLastname().length()<=0) {
			throw new Exception("Invalid Firstname");
		}
		if(personaldet.getAddress().length()<=10) {
			throw new Exception("Invalid Address");
		}
		if(personaldet.getEmail().matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")) {
			
		}
		else {
			throw new Exception("Invalid Email Address");
		}
		if(String.valueOf(personaldet.getPhonenumber()).length()==10) {
			
		}
		else{
			throw new Exception("Invalid Phone Number");
		}
		if(personaldet.getHeight()<=0) {
			throw new Exception("Invalid Height");
		}	
		if(personaldet.getWeight()<=0) {
			throw new Exception("Invalid Weight");
		}
		
		personaldetdao.save(personaldet);
		
		
	}

	@Override
	public void deleteDetails(int id) throws Exception {
			personaldetdao.findById(id).orElseThrow(()->new Exception("No Such Id exists in Database"));
		
			personaldetdao.deleteById(id);
	
		
	}

}
