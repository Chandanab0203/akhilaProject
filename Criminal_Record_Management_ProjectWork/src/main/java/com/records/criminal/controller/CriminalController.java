package com.records.criminal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.records.criminal.model.CriminalRecordBean;
import com.records.criminal.model.UserRegistrationBean;
import com.records.criminal.service.CriminalRecordService;
import com.records.criminal.service.UserService;

@Controller
public class CriminalController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	CriminalRecordService criminalService;
	
	@GetMapping("/registration")
    public String showRegistrationForm(Model model) {
		model.addAttribute("user", new UserRegistrationBean());
        return "registration";
    }

	@PostMapping(value= "/registration")
    public String registerUserAccount(@ModelAttribute("user") UserRegistrationBean registrationBean) {
        userService.save(registrationBean);
        return "redirect:/registration?success";
    }
	
	@GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }
    
    @GetMapping(value= "/register")
	public String showCriminalRegistrationPage(Model model) {
	model.addAttribute("criminal", new CriminalRecordBean());
	return "criminalregistration";	
	}
    
    @PostMapping(value="/addcriminal")
	public String registerCriminal(@ModelAttribute("criminal")CriminalRecordBean criminal) {
		criminalService.registerCriminal(criminal);	
		return "redirect:/";
	}
    @GetMapping("/about")
    public String about() {
        return "about";
    }
    
    @GetMapping("/service")
    public String service() {
        return "service";
    }
    
    @GetMapping(value="/view")
	public ModelAndView viewCriminalRecord() {
		ModelAndView mav = new ModelAndView();
		List<CriminalRecordBean> allCriminal = criminalService.getAllCriminal();
		mav.addObject("criminalList",allCriminal);
		mav.setViewName("criminal_list");
		return mav;
	}
    
	@GetMapping("/update/{fileNo}")
	public ModelAndView showFormForUpdate(@PathVariable ( value = "fileNo") int fileNo) {
		
		ModelAndView mav = new ModelAndView();
		CriminalRecordBean criminal = criminalService.getCriminalByFileNo(fileNo);
		mav.addObject("criminal", criminal);
		mav.setViewName("update_record");
		return mav;
	}
	
	@GetMapping("/delete/{fileNo}")
	public String deleteCriminalRecord(@PathVariable ( value = "fileNo") int fileNo) {
		criminalService.deleteCriminalRecord(fileNo);
		return "redirect:/";
	}
}
