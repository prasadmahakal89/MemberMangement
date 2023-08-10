package com.nt.repository;



import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;

import com.nt.entity.Member;




//@Transactional

public interface MemberRepository extends JpaRepository<Member ,Long> {
	
	
   /* @Query("ALTER TABLE Sample RENAME COLUMN first_name TO ?;"+
    "ALTER TABLE Sample RENAME COLUMN last_name TO ?;"+
    "ALTER TABLE Sample RENAME COLUMN dob TO ?;"+
    "ALTER TABLE Sample RENAME COLUMN cityy TO  ?")
				
				
	@Modifying
    public void renameColumn(String fparam,String sparam, String tparam, String foparam);
*/
	
}
