package com.isi.cafateria.repository;

import com.isi.cafateria.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee , Long> {

}
