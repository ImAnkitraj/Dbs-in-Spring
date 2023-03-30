package com.tekion.mysql.controller;

import com.tekion.mysql.datasource.model.Employee;
import com.tekion.mysql.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
// @Controller + @ResponseBody
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Value("${app.name: Employee Tracker}")
    private String appName;
    @Value("${app.version: v1}")
    private String appVersion;

    @GetMapping("/version")
    public String getAppDetails() {
        return appName + "-" + appVersion;
    }

    //    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployees(@RequestParam Integer pageNumber,
                                                       @RequestParam Integer pageSize) {
        return new ResponseEntity<List<Employee>>(employeeService.getEmployees(pageNumber, pageSize), HttpStatus.OK);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long id) {
        return new ResponseEntity<>(employeeService.getEmployee(id), HttpStatus.OK);
    }

    @DeleteMapping("/employees")
    public ResponseEntity<HttpStatus> deleteEmployee(@RequestParam("id") Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable Long id) {
        employee.setId(id);
        return new ResponseEntity<>(employeeService.updateEmployee(employee), HttpStatus.OK);
    }

    @GetMapping("/employees/filterByName")
    public ResponseEntity<List<Employee>> getEmployeesByName(@RequestParam String name) {
        System.out.println("By name hit");
        return new ResponseEntity<>(employeeService.getEmployeesByName(name), HttpStatus.OK);
    }

    @GetMapping("/employees/filterByNameAndDepartment")
    public ResponseEntity<List<Employee>> getEmployeesByNameAndDepartment(@RequestParam String name,
                                                                          String department) {
        return new ResponseEntity<>(employeeService.getEmployeesByNameAndDepartment(name, department), HttpStatus.OK);
    }

    @GetMapping("/employees/filterByNameContaining")
    public ResponseEntity<List<Employee>> getEmployeesByNameContaning(@RequestParam String keyword) {
        return new ResponseEntity<>(employeeService.getEmployeesByNameContaining(keyword), HttpStatus.OK);
    }

    @GetMapping("/employees/filterByNameOrDepartment")
    public ResponseEntity<List<Employee>> getEmployeesByNameOrDepartment(@RequestParam String name, String department) {
        return new ResponseEntity<>(employeeService.getEmployeesByNameOrDepartment(name, department), HttpStatus.OK);
    }

    @DeleteMapping("/employees/delete/{name}")
    public ResponseEntity<String> deleEmployeeByName(@PathVariable String name) {
        return new ResponseEntity<String>(employeeService.deleteEmployeeByName(name) + " records deleted",
                HttpStatus.OK);
    }
}
