package com.tekion.mysql.datasource.repository;

import com.tekion.mysql.datasource.model.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>, PagingAndSortingRepository<Employee, Long> {

    List<Employee> findByName(String name);

    List<Employee> findByNameAndDepartment(String name, String department);

    List<Employee> findByNameContaining(String keyword, Sort sort);

    @Query("FROM Employee WHERE name = :name OR department = :department")
    List<Employee> getByNameOrDepartment(String name, String department);

    @Transactional
    @Modifying
    @Query("DELETE FROM Employee WHERE name = :name")
    Integer deleteEmployeeByName(String name);
}
