package net.upskilling.departmentservice.service;

import net.upskilling.departmentservice.dto.DepartmentDto;

public interface DepartmentService {

	DepartmentDto saveDepartment(DepartmentDto departmentDto);
	DepartmentDto getDepartmentByCode(String code);
}
