package com.project.jwt.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.jwt.Entities.User;

@Repository
public interface Repository1 extends JpaRepository<User,String> {

	

	

	
}
