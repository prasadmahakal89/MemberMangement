package com.nt.serviceimpl;

import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;

import com.nt.entity.Member;
import com.nt.repository.MemberRepository;
import com.nt.service.IMemberService;


@Service
public class MemberServiceImpl implements IMemberService {
	
	private MemberRepository memberRepository;
	
	public MemberServiceImpl(MemberRepository  memberRepository) {
		super();
		this.memberRepository = memberRepository;
	}
	@Override
	public List<Member> getAllMembers() {
		
		return memberRepository.findAll();
	}
	@Override
	public Member saveMember(Member member) {
		return memberRepository.save(member);
	}
	
	@Override
	public void generateExcel(HttpServletResponse res)throws Exception {
		// TODO Auto-generated method stub
		
		List<Member>list=memberRepository.findAll();
		
		HSSFWorkbook workbook=new HSSFWorkbook();
		HSSFSheet sheet=workbook.createSheet("MemberData");
		HSSFRow row=sheet.createRow(0);
		
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("first_name");
		row.createCell(2).setCellValue("last_name");
		row.createCell(3).setCellValue("dob");
		row.createCell(4).setCellValue("city");

		
		int dataRowIndex=1;
		
		for( Member members:list) {
		HSSFRow datarow=sheet.createRow(dataRowIndex);
		
		datarow.createCell(0).setCellValue(members.getId());
		
		datarow.createCell(1).setCellValue(members.getFirstName());
		datarow.createCell(2).setCellValue(members.getLastName());
		datarow.createCell(3).setCellValue(members.getDob());
		datarow.createCell(4).setCellValue(members.getCity());
			
		dataRowIndex++;
		}
		
	ServletOutputStream sos=	res.getOutputStream();

	workbook.write(sos);
	workbook.close();
	sos.close();
			
		
	}
	
	
	
	/*@Override
	public void changeColumnName(String fparam, String sparam, String tparam, String foparam) {
		
		memberRepository.renameColumn(fparam, sparam, tparam, foparam);*/
		
	}



	

