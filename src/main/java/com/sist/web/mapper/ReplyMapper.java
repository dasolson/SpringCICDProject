package com.sist.web.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.sist.web.vo.*;
@Mapper
@Repository
public interface ReplyMapper {
	@Select("SELECT no, cno, type, id, name, msg, TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS') as dbday "
			+ "FROM comment_3 "
			+ "WHERE cno=#{cno} AND type=#{type}"
			+ "ORDER BY no DESC")
	public List<ReplyVO> replyListData(@RequestParam("cno") Integer cno, @RequestParam("type") Integer type);
	
	@Insert("INSERT INTO comment_3 VALUES( "
			+ "(SELECT NVL(MAX(no)+1,1) FROM comment_3), "
			+ "#{cno}, #{type}, #{id}, #{name}, #{msg}, SYSDATE)")
	public void replyInsert(ReplyVO vo);
}
