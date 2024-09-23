package edu.ict.ex.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.ict.ex.service.EmpService;


@Controller
public class ShopController {
	
	@Autowired
	private EmpService empService;
	
	
	@GetMapping("/")
	public String shop(Model model) {
		
		System.out.println("shop()..");
		
		model.addAttribute("empList",empService.getEmpDeptSalgrade());
		
		return "index";
	}	

}
