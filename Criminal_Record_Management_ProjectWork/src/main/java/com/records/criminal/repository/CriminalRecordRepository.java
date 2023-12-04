package com.records.criminal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.records.criminal.entity.CriminalRecordEntity;

@Repository
public interface CriminalRecordRepository extends CrudRepository<CriminalRecordEntity, Integer> {

}
