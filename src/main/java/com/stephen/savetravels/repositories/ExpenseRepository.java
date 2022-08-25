package com.stephen.savetravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stephen.savetravels.models.Expense;

@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Long> {
	
	List<Expense> findAll();

	List<Expense> findByDescriptionContaining(String search);
	
	Long countByExpenseNameContaining(String search);
	
	Long deleteByExpenseNameStartingWith(String search);
}
