package com.upskilling.organizationservice.service;

import com.upskilling.organizationservice.dto.OrganizationDto;

public interface OrganizationService {

	 OrganizationDto saveOrganization(OrganizationDto organizationDto);

	    OrganizationDto getOrganizationByCode(String organizationCode);
}
