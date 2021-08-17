package com.project.jwt.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.jwt.Entities.PersonalDetails;
@Repository
public interface PersonalDetailsDao extends JpaRepository<PersonalDetails,Integer> {

}
