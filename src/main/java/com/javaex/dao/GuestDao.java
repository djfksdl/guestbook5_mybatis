package com.javaex.dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestVo;

@Repository
public class GuestDao {
	//필드
	@Autowired
	private SqlSession sqlSession;
	//생성자
	//메소드-gs
	//메소드-일반
	
	//전체 가져오기
	public List<GuestVo> select() {
		List<GuestVo> guestList = sqlSession.selectList("guestbook.select");
		System.out.println(guestList);
		
		return guestList;
	}
	// 등록(insert)
//	public int insert(GuestVo guestVo) {
//		int count =1;
//		try {
//			//sql문 준비
//			String query ="";
//			query +=" insert into guestbook ";
//			query +=" values(null, ?, ?, ?, now()) ";
//			
//			//바인딩
//			pstmt= conn.prepareStatement(query);
//			pstmt.setString(1, guestVo.getName());
//			pstmt.setString(2, guestVo.getPw() );
//			pstmt.setString(3, guestVo.getContent());
//			
//			//실행
//			count = pstmt.executeUpdate();
//
//			System.out.println(count + "건이 등록되었습니다.");
//		}catch (SQLException e) {
//			System.out.println("error:" + e);
//			}
//		return count;
//	}
//
//	//삭제
//	public int delete(GuestVo guestVo) {
//		int count =-1;
//		try {
//			//sql문 준비
//			String query="";
//			query += " delete  ";
//			query += " from guestbook ";
//			query += " where no=?  ";
//			query += " and password=? ";
//			
//			//바인딩
//			pstmt= conn.prepareStatement(query);
//			pstmt.setInt(1, guestVo.getNo());
//			pstmt.setString(2, guestVo.getPw());
//			
//			//실행
//			count = pstmt.executeUpdate();
//		}catch (SQLException e) {
//			System.out.println("error:" + e);
//			}
//		return count;
//	}
}//Dao끝
