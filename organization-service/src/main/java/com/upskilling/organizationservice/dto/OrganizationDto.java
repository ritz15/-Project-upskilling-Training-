package com.upskilling.organizationservice.dto;

import java.time.LocalDateTime;
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
public class OrganizationDto {
	   private Long id;
	    private String organizationName;
	    private String organizationDescription;
	    private String organizationCode;
	    private LocalDateTime createdDate;
	
}
