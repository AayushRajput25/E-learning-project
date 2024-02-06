package com.app.service;

import javax.validation.Valid;

import com.app.dto.StudentSignUp;
import com.app.dto.TeacherSignUp;

public interface UserService {
//sign up
	StudentSignUp studentRegistration(StudentSignUp reqDTO);

	TeacherSignUp teacherRegistration(TeacherSignUp reqDTO);
}
