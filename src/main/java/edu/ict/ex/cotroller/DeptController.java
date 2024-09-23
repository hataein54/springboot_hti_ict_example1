package edu.ict.ex.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.ict.ex.service.DeptSevice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/dept")
public class DeptController {

	@Autowired
	private DeptSevice deptSevice;
	
	
	@GetMapping("/list")
	public String list(Model model) {
		
		System.out.println("list()..");
		
		model.addAttribute("deptList",deptSevice.getList());
		
		return "dept/list";
	}
	
	

}
