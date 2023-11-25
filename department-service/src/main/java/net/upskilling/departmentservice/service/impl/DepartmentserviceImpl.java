package net.upskilling.departmentservice.service.impl;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.upskilling.departmentservice.dto.DepartmentDto;
import net.upskilling.departmentservice.entity.Department;
import net.upskilling.departmentservice.repository.DepartmentRepository;
import net.upskilling.departmentservice.service.DepartmentService;
//import net.upskilling.departmentservice.mapper.DepartmentMapper;

@Service
@AllArgsConstructor
public class DepartmentserviceImpl implements DepartmentService {

	private DepartmentRepository  departmentRepository;
	
	@Override
	public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
		//convert dept dto to dept jpa entity
		 Department department= new Department(
				 departmentDto.getId(),
				 departmentDto.getDepartmentName(),
				 departmentDto.getDepartmentDescription(),
				 departmentDto.getDepartmentCode()
				 );
		Department savedDepartment= departmentRepository.save(department);
		 DepartmentDto savedDepartmentDto = new DepartmentDto(
				                                  savedDepartment.getId(),
				                                  savedDepartment.getDepartmentName(),
				                                  savedDepartment.getDepartmentDescription(),
				                                  savedDepartment.getDepartmentCode()
				                                     );

		return savedDepartmentDto ;
	}

	@Override
	public DepartmentDto getDepartmentByCode(String departmentCode) {
		// TODO Auto-generated method stub
		 Department department= departmentRepository.findByDepartmentCode(departmentCode);
		 DepartmentDto departmentDto= new DepartmentDto(
				 department.getId(),
				 department.getDepartmentName(),
				 department.getDepartmentDescription(),
				 department.getDepartmentCode()); 
		 
		return departmentDto;
	}
	

}
