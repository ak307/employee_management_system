package com.ak.employee_management_system.api;

import com.ak.employee_management_system.model.Employee;
import com.ak.employee_management_system.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class HomeController {
    private EmployeeService employeeService;

    @Autowired
    public HomeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("api/v1/home")
    public ModelAndView home(){
        ModelAndView mav = new ModelAndView("home.html");
        mav.addObject("employees", employeeService.getAllEmployee());
        return mav;
    }

    @GetMapping("/addNewEmployeeForm")
    public String showAddNewEmployeeForm(Model model){
        model.addAttribute(new Employee());
        return "employee_form.html";
    }



    @PostMapping("saveEmployee")
    public String saveEmployee(@ModelAttribute @Valid Employee employee, BindingResult result){
        if (result.hasErrors()){
            return "employee_form.html";
        }
        employeeService.addAnEmployee(employee);
        return "redirect:/api/v1/home";

    }


    @GetMapping("updateEmployeeForm")
    public String updateEmployeeForm(@RequestParam Long employeeId, Model model){
        Employee employee = employeeService.getEmployeeById(employeeId);
        model.addAttribute(employee);
        return "employee_form.html";
    }


    @GetMapping("deleteEmployee")
    public String deleteEmployee(@RequestParam Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return "redirect:/api/v1/home";
    }



}
