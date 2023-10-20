package com.lms.userlogin.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import com.lms.userlogin.model.Images;
import com.lms.userlogin.model.response.Response;
import com.lms.userlogin.model.response.SuccessResponse;
import com.lms.userlogin.repository.ImagesRepo;

import jakarta.transaction.Transactional;

@Service
public class ImageServiceImpl implements ImageService{
	   @Autowired
	    private ImagesRepo imageDataRepository;

	    public Response uploadImage(MultipartFile file,String email) throws IOException {
	    	Response response;
	        imageDataRepository.save(Images.builder()
	                .name(file.getOriginalFilename())
	                .type(file.getContentType())
	                .email(email)
	                .imageData(ImageUtil.compressImage(file.getBytes())).build());
	        response = new SuccessResponse(HttpStatus.CREATED.value());
	        return response;

	        
	    }
	    
	    
	    @Transactional
	    public byte[] getImage(String name) {
	        Optional<Images> dbImage = imageDataRepository.findByName(name);
	        byte[] image = ImageUtil.decompressImage(dbImage.get().getImageData());
	        return image;
	    }
	    
	    @Transactional
	    public byte[] getImageByEmail(String email) {
	        Optional<Images> dbImage = imageDataRepository.findByEmail(email);
	        byte[] image = ImageUtil.decompressImage(dbImage.get().getImageData());
	        return image;
	    }

}
