package com.lms.userlogin.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.lms.userlogin.model.response.Response;

public interface ImageService {
	
	public Response uploadImage(MultipartFile file,String email) throws IOException;

	public byte[] getImage(String name);

	public byte[] getImageByEmail(String email);
}
