package edu.ict.ex.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.ict.ex.page.Criteria;
import edu.ict.ex.page.PageVO;
import edu.ict.ex.service.DeptSevice;
import edu.ict.ex.service.EmpService;
import edu.ict.ex.vo.EmpVO;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/emp")
public class EmpController {

	@Autowired
	private EmpService empService;
	
	@Autowired
	private DeptSevice  DeptSevice;
	
	
	
	@GetMapping("/list")
	public String list(Model model) {
		
		System.out.println("list()..");
		
		model.addAttribute("empList",empService.getList());
		
		return "emp/list";
	}
	
	@GetMapping("/list6")
	public String list6(Model model) {
		
		System.out.println("list6()..");
		
		model.addAttribute("empList",empService.getEmpSalgrade());
		
		return "emp/list6";
	}
	
	@GetMapping("/list7")
	public String list7(Model model) {
		
		System.out.println("list7()..");
		
		model.addAttribute("empList",empService.getEmpDeptSalgrade());
		
		return "emp/list7";
	}
	
	
	
	@GetMapping("/insert_view")
	public String insert_view(Model model) {
		
		System.out.println("insert_view()..");
		
		model.addAttribute("empList", empService.getList());
		model.addAttribute("deptList",DeptSevice.getList());
			
		
		return "emp/insert";
	}
	
	@PostMapping("/insert")
	public String insert(EmpVO empVO) {
		
		System.out.println("insert()..");
		System.out.println(empVO);
		
		empService.insert(empVO);
		
		return "redirect:/emp/list";
	}
	
	@GetMapping("/list2")
	public String list2(Criteria criteria, Model model) {
		System.out.println();
			
		model.addAttribute("empList", empService.getListWithPaging(criteria));
		
		int total = empService.getTotal();
		model.addAttribute("pageMaker", new PageVO(criteria,total));
		
		return "emp/list2";
	}
	

}
