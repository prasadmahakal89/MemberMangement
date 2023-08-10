package com.nt.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.nt.entity.Member;


public interface IMemberService {
	
	List<Member>getAllMembers();

	Member saveMember(Member member);
	
	public void generateExcel(HttpServletResponse res) throws Exception;
	
//	public void changeColumnName(String fparam,String sparam, String tparam, String foparam);


}
