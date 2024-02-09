package com.app.service;

import javax.validation.constraints.NotNull;

import com.app.dto.ApiResponse;
import com.app.dto.CoursesDto;
import com.app.entities.Courses;

public interface TeacherService {

	ApiResponse newCourseByTID(Long teacherId, CoursesDto course);

	java.util.List<Courses> getAllCourses();

	java.util.List<Courses> getCoursesById(@NotNull Long teacherId);

	ApiResponse deleteCourseById(@NotNull Long CourseId);

}
