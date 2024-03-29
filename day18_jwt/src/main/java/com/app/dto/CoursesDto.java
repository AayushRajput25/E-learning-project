package com.app.dto;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class CoursesDto {
	
	@Length(max = 100)
	private String courseName;

	@Length(max = 4000)
	private String description;
	
//	@JsonProperty(access = Access.READ_ONLY)
//	private Teachers tId;
//	
}
