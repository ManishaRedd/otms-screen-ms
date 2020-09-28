package com.capg.otms.ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capg.otms.ms.model.Login;

@Repository
public interface LoginRepo extends  JpaRepository<Login, String>{


	@Query(" FROM Login where username=:Capgemini and password=:capgemini")
	public Login findUser(@Param("Capgemini") String username,@Param("capgemini") String password);
}
