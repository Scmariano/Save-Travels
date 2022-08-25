package com.stephen.savetravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.stephen.savetravels.models.Expense;
import com.stephen.savetravels.services.ExpenseService;

@Controller
public class ExpenseController {

		@Autowired
		ExpenseService expenseService;
		
		@GetMapping("/")
		public String redirect() {
			return "redirect:/expenses";
		}
		
		@GetMapping("/expenses")
		public String index(Model model, @ModelAttribute("expense") Expense expense) {
			List<Expense> expenses = expenseService.allExpense();
			model.addAttribute("expenses", expenses);
			return "index.jsp";
		}
		
		
		@PostMapping("/expense")
		public String newExpense(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
			if(result.hasErrors()) {
				List<Expense> expenses = expenseService.allExpense();
				model.addAttribute("expenses", expenses);
				return "index.jsp";
			}else {
				expenseService.createExpense(expense);
				return "redirect:/expenses";
			}
		}
		
		@GetMapping("/expense/edit/{id}")
	    public String edit (@PathVariable("id") Long id, Model model ) {
	    	Expense expense = expenseService.findExpense(id);
			model.addAttribute("expense", expense);
			return "/edit.jsp";
			
	    }
		
		@PutMapping("/expense/{id}")
		public String update (@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
			if(result.hasErrors()) {
				return"edit.jsp";
			}else {
				expenseService.updateExpense(expense);
				return"redirect:/expense";
			}
		}
		
		
		
}
