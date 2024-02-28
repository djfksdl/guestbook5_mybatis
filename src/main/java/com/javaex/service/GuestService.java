package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestDao;
import com.javaex.vo.GuestVo;

@Service
public class GuestService {
	//필드
	@Autowired
	private GuestDao guestDao;
	
	//생성자
	//메소드-gs
	//메소드-일반
	//리스트 불러오기
	public List<GuestVo> exeList() {
		System.out.println("GuestService.exeList");
		
		//Dao연결
		List<GuestVo> guestList = guestDao.select();
		
		return guestList;
	}
	
	//등록
//	public int exeInsert(GuestVo guestVo) {
//		//DB연결
//		int count = guestDao.insert(guestVo);
//		return count;
//	}
//	//삭제폼
////	public GuestVo exeDform(int no) {
////		//DB연결
////		GuestVo guestVo =guestDao.dform(no);
//
////		return guestVo;
////	}
//	//삭제
//	public int exeDelete(GuestVo guestVo) {
//		//DB연결
//		int count = guestDao.delete(guestVo);
//		return count;
//	}
}
