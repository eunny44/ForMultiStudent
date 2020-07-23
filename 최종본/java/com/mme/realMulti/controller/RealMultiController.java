package com.mme.realMulti.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mme.realMulti.dto.Admin;
import com.mme.realMulti.dto.ImgData;
import com.mme.realMulti.dto.Locker;
import com.mme.realMulti.dto.MT;
import com.mme.realMulti.service.AdminService;
import com.mme.realMulti.service.ImgDataService;
import com.mme.realMulti.service.LockerService;
import com.mme.realMulti.service.MTService;
import java.sql.Timestamp;
import java.util.Date;

@Controller
public class RealMultiController {

	@Autowired
	LockerService lockerService;
	
	@Autowired
	MTService mtService;
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	ImgDataService imgDataService;
	
	
	//index 페이지 보여줌.
	@GetMapping(path="/index")
	public String index() {
		return "index";
	}
	
	//사물함 신청 페이지 보여줌.
	@GetMapping(path="/locker")
	public String locker(ModelMap model,
			   HttpServletRequest request,
			   HttpServletResponse response) {
		
		List<Locker> list = lockerService.getLockers();
		model.addAttribute("list", list);
		
		//0405
		//GetMapping에서는 request의 setAttribute가 되는데 PostMapping에서 안된다는 걸 배웠다.
	
		//200623
		Admin ad = adminService.getAdminInfo("lockerInfo");
		Timestamp stamp1 = ad.getStartDate();
		Timestamp stamp2 = ad.getEndDate();

		model.addAttribute("area", ad.getArea());
		model.addAttribute("title", ad.getTitle());
		model.addAttribute("applyStart", stamp1);
		model.addAttribute("applyEnd", stamp2);		
		
		return "locker";
	}
	
	//MT신청페이지 보여줌.
	@GetMapping(path="/mt")
	public String mt(ModelMap model) {
		List<MT> list = mtService.getMTs();
		model.addAttribute("mtlist", list);
		
		//200416
		ImgData imgdata = imgDataService.getImgName("mtInfoImg");
		String tmp = (String)imgdata.getImgName();

		String mtimgpath = "resources/images/" + tmp;
		model.addAttribute("mtimgpath", mtimgpath);
		
		//200621
		//근데 생각해보니까.. 이거 나중에 MT 종류가 여러개가 되면 조금 골치아플 듯.
		Admin ad2 = adminService.getAdminInfo("mtInfo");
		Timestamp stamp1 = ad2.getStartDate();
		Timestamp stamp2 = ad2.getEndDate();
		
		model.addAttribute("area", ad2.getArea());
		model.addAttribute("mtTitle", ad2.getTitle());
		model.addAttribute("mtContent", ad2.getContent());
		model.addAttribute("applyStart", stamp1);
		model.addAttribute("applyEnd", stamp2);
		
		return "mt";
	}		
	
	//마이페이지 보여줌.
	@GetMapping(path="/mypage")
	public String mypage() {
		return "mypage";
	}
	
	//테스트한거라 신경 안써도 됨.
	@GetMapping(path="/myTest")
	public String myTest(ModelMap model,
			   HttpServletRequest request,
			   HttpServletResponse response) {
		List<Locker> list = lockerService.getLockers();
		model.addAttribute("list", list);
	
		return "myTest";
	}
	
	@GetMapping(path="/modifyMT")
	public String modifyMT(
			@RequestParam(name="area", required=true) String area,
			ModelMap model
			) {
		Admin ad = adminService.getAdminInfo(area);
		
		//200627
		//이미지도 이 페이지 내에서 변경을 할거라면
		//마찬가지로 기본 값을 가지고 있어야 할 것임..
		ImgData imgdata = imgDataService.getImgName("mtInfoImg");
		String tmp = (String)imgdata.getImgName();

		String mtimgpath = "resources/images/" + tmp;
		model.addAttribute("mtimgpath", mtimgpath);
		
		//
		model.addAttribute("area", ad.getArea());
		model.addAttribute("mtTitle", ad.getTitle());
		model.addAttribute("mtContent", ad.getContent());
		
		return "modifyMT";
	}
	
	//200623
	@GetMapping(path="/modifyLocker")
	public String modifyLocker(
			@RequestParam(name="area", required=true) String area,
			ModelMap model
			) {
		Admin ad = adminService.getAdminInfo(area);
		
		model.addAttribute("area", ad.getArea());
		model.addAttribute("title", ad.getTitle());
		
		return "modifyLocker";
	}
}
