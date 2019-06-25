package kr.or.ksmart.lms.association.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ksmart.lms.association.service.AssociationInstitutionService;
import kr.or.ksmart.lms.association.vo.Institution;

@Controller
public class AssociationInstitutionController {
	@Autowired private AssociationInstitutionService associationInstitutionService;
	
	// association layout 교육원 리스트 출력 controller
	@GetMapping("/association/institution/institutionList")
	public ModelAndView associationGetInstitutionList(ModelAndView mav, HttpSession session) {
		String memberRank = (String)session.getAttribute(("memberRank"));
		if(memberRank == null) {
			memberRank="로그인 실패";
		}
		if(memberRank.equals("협회직원")) {
			System.out.println("협회직원");
			
			System.out.println("[AssociationInstitutionController associationGetInstitutionList]");
			// service에서 받아온 교육원 정보들이 담긴 list를 mav에 담아 뷰에서 활용한다. 
			List<Institution> list = associationInstitutionService.associationGetInstitutionList();			
			mav.setViewName("association/institution/institutionList");
			mav.addObject("list", list);
		}else {
			System.out.println("협회직원아님");
			
			mav.setViewName("association/associationLogin");
		}
		return mav;
	}


}
