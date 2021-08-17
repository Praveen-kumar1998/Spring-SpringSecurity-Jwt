package com.project.jwt.serviceInterface;

import com.project.jwt.Entities.PersonalDetails;


public interface PersonalDetService{

	public void savedetails(PersonalDetails personaldetails) throws Exception;
	public void deleteDetails(int id) throws Exception;
}
