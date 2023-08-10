package com.nt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nt.repository.MemberRepository;


@SpringBootApplication
public class MemberManagementSystemApplication implements CommandLineRunner {

	
	
	
	public static void main(String[] args) {
		SpringApplication.run(MemberManagementSystemApplication.class, args);
	}
	
	@Autowired
	private MemberRepository memberRepository;

	@Override
	public void run(String... args) throws Exception {
		
	
	
		
	}

}
