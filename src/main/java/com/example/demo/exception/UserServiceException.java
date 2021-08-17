package com.example.demo.exception;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class UserServiceException {
    public static String UploadOneFile(MultipartFile file,String fileUpload){
        String fileName= file.getOriginalFilename();
        try{
            FileCopyUtils.copy(file.getBytes(),new File(fileUpload + fileName));
        }catch (IOException e){
            System.out.println("Upload that bai ");
        }
        return fileName;
    }

}
