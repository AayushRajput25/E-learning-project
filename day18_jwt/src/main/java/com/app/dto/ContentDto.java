package com.app.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.app.entities.Courses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ContentDto {

//	@NotNull
//	private Courses cId;
	
	@Length(max = 100)
	private String title;
	
	private String filePath;
	
	private String description;
		
	
}
