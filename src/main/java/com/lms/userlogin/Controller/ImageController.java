package com.lms.userlogin.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lms.userlogin.model.response.Response;
import com.lms.userlogin.service.ImageService;

@CrossOrigin("*")
@RestController
@RequestMapping("/image")
public class ImageController {
	

    @Autowired
    private ImageService imageService;
    
    @PostMapping
    public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file,String email) throws IOException {
        Response response = imageService.uploadImage(file,email);

        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
  
    }
    
    @GetMapping("/get")
    public ResponseEntity<?>  getImageByEmail(@RequestParam("email") String email){
        byte[] image = imageService.getImageByEmail(email);

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(image);
    }
}
