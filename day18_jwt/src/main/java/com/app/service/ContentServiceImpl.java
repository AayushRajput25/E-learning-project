package com.app.service;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.ContentDao;
import com.app.dao.CourseDao;
import com.app.dto.ApiResponse;
import com.app.dto.ContentDto;
import com.app.entities.Content;
import com.app.entities.Courses;

@Service
@Transactional
public class ContentServiceImpl implements ContentService{

	@Autowired
	private CourseDao cDao;
	
	@Autowired
	private ContentDao contentDao;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public ApiResponse newContentByCId(@NotNull Long courseId, ContentDto content) {
		Courses cou =  cDao.findById(courseId).orElseThrow(()-> new ResourceNotFoundException("Course Not exist"));
		Content cont = mapper.map(content, Content.class);
		System.out.println("FINAL DEBUGGING!!! --- "+cont.getDescription());
		cou.addCourse(cont);
		contentDao.save(cont);	
		return new ApiResponse("Added successfully");
	}

	
}
