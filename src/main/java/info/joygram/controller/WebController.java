package info.joygram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//for rest controller
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

import info.joygram.mapper.WebMapper;
import lombok.extern.slf4j.Slf4j;


//@RestController //결과값만 전송하는 경우 

//template를 사용하는 경우는 @RestController를 쓰지 않는다. 
@Slf4j
@Controller
public class WebController {
	@Autowired
	WebMapper webMapper;

	//@RequestMapping("/")
	// String home() {
	// 	String result = webMapper.selectFromDb();
	// 	return "Hello Spring? ${result} ";
	// }

	@GetMapping("/")
	String handleHome(Model model) {
		//템플릿에 포함된 값을 지정한다. 
		model.addAttribute("message", "joygram's world");
		return "home"; // 템플릿 greeting.html과 일치시킨다. 
	}

	@GetMapping("/info")
	String handleInfo(Model model) {

		
		// 템플릿에 포함된 값을 지정한다.
		model.addAttribute("info_dataset", "{\"nice\": \"data\"}");
		return "info"; // 템플릿 greeting.html과 일치시킨다.
	}

	@GetMapping("/login")
	String handleLogin(Model model) {

		// 템플릿에 포함된 값을 지정한다.
		model.addAttribute("info_dataset", "{\"nice\": \"data\"}");
		return "login"; // 템플릿 greeting.html과 일치시킨다.
	}
	
}
