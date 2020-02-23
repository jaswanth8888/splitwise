package com.splitwise.expenditure.expenditure.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.splitwise.expenditure.expenditure.Service.ExpenditureService;
import com.splitwise.expenditure.expenditure.beans.Expenditure;

@RestController
public class ExpenditureController {
	
	@Autowired
	private ExpenditureService expenditureService;
	
	@GetMapping("/expenditure/{eId}")
	public Expenditure getExpenditureById(@PathVariable Integer eId) {
		if(expenditureService.checkExpenditureExsists(eId)) {
			Expenditure expenditure= expenditureService.getExpenditureById(eId).get();
			return expenditure;
		}
		return null;		
	}
	
	
	@PostMapping("/expenditure")
	public Expenditure createExpenditure(@RequestBody Expenditure expenditure) {
		return expenditureService.createExpenditure(expenditure);
	}
}
