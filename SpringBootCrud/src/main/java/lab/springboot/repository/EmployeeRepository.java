package lab.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lab.springboot.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
