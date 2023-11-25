package net.upskilling.employeeservice.repository;
import net.upskilling.employeeservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository  extends JpaRepository<Employee, Long>{ 
	
}
