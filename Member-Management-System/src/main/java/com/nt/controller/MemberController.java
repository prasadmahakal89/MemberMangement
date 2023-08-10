package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.entity.Member;
import com.nt.repository.MemberRepository;
import com.nt.service.IMemberService;
//import com.nt.serviceimpl.ReportService;


@Controller
public class MemberController {
	//for excel doc
	@GetMapping("/members/excel")
	public void generateExcelReport(HttpServletResponse res)throws Exception {
		res.setContentType("application/octet-stream");
		
		String headerKey="Content-Disposition";
		
		String headerValue="attachment;filename=student.xls";
		res.setHeader(headerKey, headerValue);

		memberService.generateExcel(res);
	}
	//End of Excel

	private IMemberService memberService;

	public MemberController(IMemberService memberService) {
		super();
		this.memberService = memberService;
	}
	
	
	
	@GetMapping("/members")
	public String listMember(Model model){
		
		model.addAttribute("members",  memberService.getAllMembers());
		return "members";//LVN goes to template from here
	}
	
	
	@GetMapping("/members/new")
	public String createStudentForm(Model model) {
		
		//create member obj to hold form data
		Member member=new Member();
		model.addAttribute("member",member);
		return "create_member";
	}
	
	
	@PostMapping("/members")
	public String saveStudent(@ModelAttribute("member")Member member) {
		
		memberService.saveMember(member);
		
		return"redirect:/members";
	//	return "final_page";

		
	}
	

	
	
	
	
	//chage col name
	
	/*@GetMapping("/changecol")
	public String changecol() {
		return "change";
		
	}
	
	@PostMapping("/submit/{fparam},{sparam},{tparam},{foparam}")
	 public String updateColName(@PathVariable String fparam,@PathVariable String sparam,@PathVariable String tparam,@PathVariable String foparam) {
		
		memberService.changeColumnName(fparam, sparam, tparam, foparam);
		
		return"redirect:/members";
	}*/
		
		
	}
	

