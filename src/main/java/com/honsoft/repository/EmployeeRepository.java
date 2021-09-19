package com.honsoft.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.honsoft.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Page<Employee> findAll(Pageable pageable);

    Page<Employee> findByFirstName(String firstName, Pageable pageable);

    Slice<Employee> findByFirstNameAndLastName(String firstName, String lastName, Pageable pageable);
}