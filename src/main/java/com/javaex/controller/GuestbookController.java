package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.GuestService;
import com.javaex.vo.GuestVo;

@Controller
public class GuestbookController {
	//필드
	@Autowired
	private GuestService guestService;
	//생성자
	//메소드-gs
	//메소드-일반
	
	//메인폼
	//localhost:8080/guestbook5(여기까지 공통주소)/guest/alform
	@RequestMapping(value="/gbc/alform", method= {RequestMethod.GET, RequestMethod.POST})
	public String alform(Model model) {
		System.out.println("GuestbookController.alform()");
		
//		//서비스로 연결
		List<GuestVo> guestList= guestService.exeList();
		
		//model에 올리기
		model.addAttribute("guestList" ,guestList);
		
//		
//		//포워드
		return "addList";
		
		
	}
	//등록
//	@RequestMapping(value="/gbc/insert", method= {RequestMethod.GET, RequestMethod.POST})
//	public String insert(GuestVo guestVo) {
//		System.out.println("GuestbookController.insert");
//		//파라미터 받아서 vo로 묶기- 근데 다 받는거여서 그냥 vo로 받는건가? 다 들어있긴함
//		System.out.println(guestVo.toString());
//		//서비스 연결(vo보내기)
//		guestService.exeInsert(guestVo);
////		//리다이렉트
//		return "redirect:/gbc/alform";
//		
//	}
//	//삭제폼
//	@RequestMapping(value="/gbc/dform", method= {RequestMethod.GET, RequestMethod.POST })
//	public String dform() {
//		System.out.println("GuestbookController.dform");
//		
//		//서비스 연결-안함-> jsp에서 input:hidden으로 no숨기기. 다른 데이터 안가져와도 나중에 '삭제'에서 no받을 수 있음.
//		
//		//포워드
//		return "deleteForm";
//	}
//	//삭제
//	@RequestMapping(value="/gbc/delete", method= {RequestMethod.GET, RequestMethod.POST})
//	public String  delete(@RequestParam("no") int no, String pw) {
//		System.out.println("GuestbookController.delete");
//		// 넣는 값들 가져와서 vo로 묶기
//		GuestVo guestVo = new GuestVo(no, pw);
//		
//		//서비스 연결
//		guestService.exeDelete(guestVo);
//		
//		//리다이렉트
//		return "redirect:/gbc/alform";
//	}
}
