package com.pack.SpringBootRoleBasedSecurity.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pack.SpringBootRoleBasedSecurity.model.Leave;
import com.pack.SpringBootRoleBasedSecurity.model.Role;
import com.pack.SpringBootRoleBasedSecurity.model.User;
import com.pack.SpringBootRoleBasedSecurity.service.LeaveService;

import com.pack.SpringBootRoleBasedSecurity.service.UserService;
import com.pack.SpringBootRoleBasedSecurity.validator.UserValidator;



@Controller
public class UserController {
    @Autowired
    private UserService userService;
    
    @Autowired
    private LeaveService leaveService;

    @Autowired
    private UserValidator userValidator;
    
    @RequestMapping(value = {"/", "/registration"}, method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
    	userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration";
        }
//        Set<Role> role=userForm.getRoles();
//        userForm.setRoles(role);
       userService.save(userForm);
   model.addAttribute("message", "You have been registered successfully");

        return "login";
    }
    @GetMapping("/login")
    public String loginm() {
    	return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("username") String username,@RequestParam("password") String password,Model model, String error, String logout) {
    	User user1 = userService.findByUsername(username,password);
    	//System.out.println(user1.getUsername());
        /*if (!(user1.getUsername().equals(username)|| user1.getPassword().equals(password)))
        {
        	model.addAttribute("error", "Your username and password is invalid.");
        	return "redirect:/login";
        }
*/
//    	if(user1==null) {
//
//        	model.addAttribute("error", "Your username and password is invalid.");
//        	return "redirect:/login";
//    	}
        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "redirect:/welcome";
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome(Model model) {
    	List<Leave> list=leaveService.fetchAllLeaves();
    	model.addAttribute("llist",list);
        return "welcome";
    }
   
    @ModelAttribute("roleList")
	public Map<Integer,String> initializeRoles() {
    	Map<Integer, String> map = new HashMap<Integer, String>();
    	map.put(1,"employee");
		map.put(2,"RM");
	
		return map;
	}
    
    @RequestMapping(value="/new",method=RequestMethod.GET)
    public String createLeave(Model model) {
    	model.addAttribute("leaveForm", new Leave());
    	return "new_leave";
    }
    
    @RequestMapping(value="/save",method=RequestMethod.POST)
    public String addLeave(@ModelAttribute("leaveForm") Leave leave) {
    	Random rand=new Random();
    	long id=rand.nextInt(90000)+10000;
    	leave.setId(id);
    	leaveService.saveLeave(leave);
    	return "redirect:/welcome";   	
    }
    
    @RequestMapping(value="/Approve/{lid}")
    public String fetchLeave(@PathVariable("lid") long id,Model model) {
    	Leave leav=leaveService.getLeaveById(id);
    	model.addAttribute("editLeave",leav);
    	return "edit_leave";
    }
    
    @RequestMapping(value="/Approve",method=RequestMethod.POST)
    public String updateLeave(@ModelAttribute("editLeave") Leave leave) {
    	System.out.println("update"+leave);
    	leaveService.updateLeave(leave);
System.out.println("Your Leave is Approved");
    	return "redirect:/welcome";  
    }
    
    @RequestMapping(value="/Reject/{lid}")
    public String deleteLeave(@PathVariable("lid") long id) {
    	leaveService.deleteLeave(id);
    	return "redirect:/welcome";  
    }
    
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied() {
        return "403";
    }

    
}