package com.app.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface StudentService {

	Object uploadImage(Long studentID, MultipartFile imageFile) throws IOException;

	byte[] downloadImage(Long studentID) throws IOException;
	
	String uploadImageToFileSystem(MultipartFile file) throws IOException;
	
	byte[] downloadImageFromFileSystem(String fileName) throws IOException;

	
}
