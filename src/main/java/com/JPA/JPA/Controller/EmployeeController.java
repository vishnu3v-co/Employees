package com.JPA.JPA.Controller;

import com.JPA.JPA.DTO.EmployeeDTO;
import com.JPA.JPA.Service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable("employeeId") Long employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    @GetMapping
    public List<EmployeeDTO> findAll() {
        return employeeService.findAll();
    }

    @PostMapping
    public EmployeeDTO save(@RequestBody EmployeeDTO employees) {
        return employeeService.save(employees);
    }

    @PutMapping("/{employeeId}")
    public EmployeeDTO update(@RequestBody EmployeeDTO employees,@PathVariable long  employeeId) {
        return employeeService.update(employees,employeeId);
    }

    @DeleteMapping("/{employeeId}")
    public void delete(@PathVariable long employeeId) {
        employeeService.remove(employeeId);
    }

}
