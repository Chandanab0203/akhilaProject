package com.records.criminal.service;

import java.util.List;

import com.records.criminal.entity.CriminalRecordEntity;
import com.records.criminal.model.CriminalRecordBean;

public interface CriminalRecordService {

	public CriminalRecordEntity registerCriminal(CriminalRecordBean criminal);

	

	public List<CriminalRecordBean> getAllCriminal();



	public CriminalRecordBean getCriminalByFileNo(int fileNo);



	public void deleteCriminalRecord(int fileNo);

	
}
