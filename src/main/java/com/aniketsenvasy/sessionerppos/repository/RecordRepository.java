package com.aniketsenvasy.sessionerppos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aniketsenvasy.sessionerppos.model.UserRecord;

@Repository
public interface RecordRepository extends JpaRepository<UserRecord, Long> {

}

