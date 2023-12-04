package com.records.criminal.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.records.criminal.entity.CriminalRecordEntity;
import com.records.criminal.model.CriminalRecordBean;
import com.records.criminal.repository.CriminalRecordRepository;
import com.records.criminal.service.CriminalRecordService;

@Service
public class CriminalRecordServiceImpl implements CriminalRecordService {

	@Autowired
	CriminalRecordRepository criminalRepo;
	
	@Override
	public CriminalRecordEntity registerCriminal(CriminalRecordBean criminal) {
		CriminalRecordEntity entity = new CriminalRecordEntity();
		BeanUtils.copyProperties(criminal, entity);
		CriminalRecordEntity save = criminalRepo.save(entity);
		return save;
	}

	@Override
	public List<CriminalRecordBean> getAllCriminal() {
		List<CriminalRecordBean> criminalList = new ArrayList<>();
		List<CriminalRecordEntity> findAll = (List<CriminalRecordEntity>) criminalRepo.findAll();
		
		findAll.forEach(data->{
			CriminalRecordBean bean = new CriminalRecordBean();
			BeanUtils.copyProperties(data, bean);
			criminalList.add(bean);
		});
		return criminalList;
		
	}

	@Override
	public CriminalRecordBean getCriminalByFileNo(int fileNo) {
		
		CriminalRecordBean bean = new CriminalRecordBean();
		Optional<CriminalRecordEntity> findByFileNumber = criminalRepo.findById(fileNo);
		if(findByFileNumber.isPresent())
		{
			CriminalRecordEntity entity = findByFileNumber.get();
			BeanUtils.copyProperties(entity, bean);
		}else
		{
			throw new RuntimeException(" Criminal record not found for file Number :: " + fileNo);
		}
		return bean;
	}

	@Override
	public void deleteCriminalRecord(int fileNo) {
		
		criminalRepo.deleteById(fileNo);
		
		
	}

}
