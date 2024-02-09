package com.app.service;

import javax.validation.constraints.NotNull;

import com.app.dto.ApiResponse;
import com.app.dto.ContentDto;

public interface ContentService {

	ApiResponse newContentByCId(@NotNull Long courseId, ContentDto course);

}
