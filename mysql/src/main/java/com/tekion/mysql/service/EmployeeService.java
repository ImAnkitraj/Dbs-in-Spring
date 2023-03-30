package com.tekion.mysql.service;

import com.tekion.mysql.datasource.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees(Integer pageNumber, Integer pageSize);
    Employee saveEmployee(Employee employee);

    Employee getEmployee(Long id);
    void deleteEmployee(Long id);
    Employee updateEmployee(Employee e);

    List<Employee> getEmployeesByName(String name);
    List<Employee> getEmployeesByNameAndDepartment(String name, String department);
    List<Employee> getEmployeesByNameContaining(String keyword);

    List<Employee> getEmployeesByNameOrDepartment(String name, String department);
    Integer deleteEmployeeByName(String name);
}
