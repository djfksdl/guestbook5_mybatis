package com.javaex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestVo;

@Repository
public class GuestDao {
	//필드
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	//생성자
	//메소드-gs
	//메소드-일반
	//전체연결
	public void getConnection() {
		
		try {
		// 1. JDBC 드라이버 (Oracle) 로딩
		Class.forName(driver);
		
		// 2. Connection 얻어오기
		String url = "jdbc:mysql://localhost:3306/guestbook_db";
		conn = DriverManager.getConnection(url, "guestbook", "guestbook");

		
		// 4.결과처리
		} catch (ClassNotFoundException e) {
		System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		System.out.println("error:" + e);
		} 
	}
	//마무리
	public void close() {
		try {
			if (rs != null) {
			rs.close();
			} 
			if (pstmt != null) {
			pstmt.close();
			}
			if (conn != null) {
			conn.close();
			}
			} catch (SQLException e) {
			System.out.println("error:" + e);
			}
	}
	
	public List<GuestVo> select() {
		List<GuestVo> guestList = new ArrayList<GuestVo>();
		this.getConnection();
		try {
			//sql문 준비
			String query = "";
			query += " select no ";
			query += " 		 ,name ";
			query +=" 		 ,password ";
			query += " 		 ,reg_date ";
			query += " 		 ,content ";
			query += " from guestbook ";
			
			//바인딩
			pstmt= conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			//실행
			while(rs.next()) {
				int no = rs.getInt("no");
				String name = rs.getString("name");
				String pw =rs.getString("password");
				String reg_date = rs.getString("reg_date");
				String content = rs.getString("content");
				
				//vo로 묶기 
				GuestVo guestVo = new GuestVo(no, name, reg_date,content);
				guestList.add(guestVo);
				
			}
			
		}catch (SQLException e) {
			System.out.println("error:" + e);
			}
		this.close();
		return guestList;
	}
	// 등록(insert)
	public int insert(GuestVo guestVo) {
		int count =1;
		this.getConnection();
		try {
			//sql문 준비
			String query ="";
			query +=" insert into guestbook ";
			query +=" values(null, ?, ?, ?, now()) ";
			
			//바인딩
			pstmt= conn.prepareStatement(query);
			pstmt.setString(1, guestVo.getName());
			pstmt.setString(2, guestVo.getPw() );
			pstmt.setString(3, guestVo.getContent());
			
			//실행
			count = pstmt.executeUpdate();

			System.out.println(count + "건이 등록되었습니다.");
		}catch (SQLException e) {
			System.out.println("error:" + e);
			}
		this.close();
		return count;
	}

	//삭제
	public int delete(GuestVo guestVo) {
		this.getConnection();
		int count =-1;
		try {
			//sql문 준비
			String query="";
			query += " delete  ";
			query += " from guestbook ";
			query += " where no=?  ";
			query += " and password=? ";
			
			//바인딩
			pstmt= conn.prepareStatement(query);
			pstmt.setInt(1, guestVo.getNo());
			pstmt.setString(2, guestVo.getPw());
			
			//실행
			count = pstmt.executeUpdate();
		}catch (SQLException e) {
			System.out.println("error:" + e);
			}
		this.close();
		return count;
	}
}//Dao끝
