package com.aniketsenvasy.sessionerppos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aniketsenvasy.sessionerppos.model.UserVo;



@Repository
public interface UserRepository extends JpaRepository<UserVo, Long>  {
	UserVo findByUsername(String username);
}
