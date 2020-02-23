package com.splitwise.expenditure.expenditure.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.splitwise.expenditure.expenditure.Repository.ExpenditureRepository;
import com.splitwise.expenditure.expenditure.beans.Expenditure;

@Service
public class ExpenditureService {
	@Autowired
	private ExpenditureRepository expenditureRepository;
	
	public Expenditure createExpenditure(Expenditure expenditure) {
		return expenditureRepository.insert(expenditure);
	}
	
	public Optional<Expenditure> getExpenditureById(Integer eId) {
		return expenditureRepository.findById(eId);
	}
	
	public boolean checkExpenditureExsists(Integer eId) {
		return expenditureRepository.existsById(eId);
	}
}
