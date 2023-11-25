package net.upskilling.departmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.upskilling.departmentservice.entity.Department;

public interface DepartmentRepository  extends JpaRepository<Department, Long>{

	Department  findByDepartmentCode(String departmentCode);
}
