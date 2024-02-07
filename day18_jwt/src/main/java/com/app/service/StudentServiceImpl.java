package com.app.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.dao.ContentDao;
import com.app.dao.StudentDao;
import com.app.entities.Students;
import com.app.entities.Content;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDao dao;
	
	@Autowired
	private ContentDao fileDataRepository;
	

	@Override
	public String uploadImage(Long empId, MultipartFile image) throws IOException {
		// get emp from emp id
		Students stu = dao.findById(empId).
				orElseThrow();
		// emp found --> PERSISTENT
		// to store the img directly in DB as a BLOB
		stu.setProfilePic(image.getBytes());
		dao.save(stu);
		return ("Image file uploaded successfully for emp id " + empId);
	}


	@Override
	public byte[] downloadImage(Long empId) throws IOException {
		// get emp by id
		Students stu = dao.findById(empId).orElseThrow();
		// emp found --> PERSISTENT
		return stu.getProfilePic();
	}

	 private final String FOLDER_PATH="C:\\Users\\Utkar\\OneDrive\\Desktop\\New folder\\";

    public String uploadImageToFileSystem(MultipartFile file) throws IOException {
        String filePath=FOLDER_PATH+file.getOriginalFilename();

        Content fileData=fileDataRepository.save(Content.builder()
                .name(file.getOriginalFilename())
                .filePath(filePath).build());

        file.transferTo(new File(filePath));

        if (fileData != null) {
            return "file uploaded successfully : " + filePath;
        }
        return null;
    }

    public byte[] downloadImageFromFileSystem(String fileName) throws IOException {
        Optional<Content> fileData = fileDataRepository.findByName(fileName);
        String filePath=fileData.get().getFilePath();
        byte[] images = Files.readAllBytes(new File(filePath).toPath());
        return images;
    }



}
