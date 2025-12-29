package com.sist.web.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.sist.web.vo.MemberVO;

@Mapper
@Repository
public interface MemberMapper {
	// id 체크
	@Select("SELECT COUNT(*) FROM member_3 WHERE id=#{id}")
	public int memberIdCheck(String id);
	// pwd 체크
	@Select("SELECT pwd, name, sex, address, id "
			+ "FROM member_3 "
			+ "WHERE id=#{id}")
	public MemberVO memberInfoData(String id);
}
