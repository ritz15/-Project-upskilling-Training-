package com.example.SpringbootRestfulwebservices.dto;



import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        description = "UserDto Model Information"
)

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	
	private Long id;
	  @Schema(
	            description = "User First Name"
	    )
	@NotEmpty(message="user's first name should not ne empty or blank")
	private String firstName;
	  @Schema(
	            description = "User Last Name"
	    )
	@NotEmpty(message="user's last name should not ne empty or blank")
	private String lastName;
	  @Schema(
	            description = "User Email Address"
	    )
	@NotEmpty(message="user's mail id should not ne empty or blank")
	@Email(message="pls enter valid email format")
	private String email;

}
