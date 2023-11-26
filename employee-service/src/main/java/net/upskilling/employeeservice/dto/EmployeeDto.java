package net.upskilling.employeeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        description = "EmployeeDto Model Information"
)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String departmentCode;
	private String organizationCode;
}
