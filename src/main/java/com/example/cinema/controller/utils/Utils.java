package com.example.cinema.controller.utils;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;


import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import org.springframework.web.multipart.MultipartFile;




@Component
public class Utils  {

 

    static private String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/media/";
    public static String saveFile(MultipartFile file)
    {
     
        File directory = new File(uploadDir);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        try {
            // Generate a unique filename
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            String uniqueFileName = UUID.randomUUID().toString() + "_" + fileName;

            // Path where the file will be saved
            Path filePath = Paths.get(uploadDir + uniqueFileName);

            // Save the file to the specified path
            Files.copy(file.getInputStream(), filePath);
            return "/media/" + uniqueFileName;
        } catch (IOException ex) {
            ex.printStackTrace();
            return  null;
        }
    }

    public static void deleteFile(String filename) {
        File file = new File(uploadDir+filename);
        
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("File deleted successfully: " + filename);
            } else {
                System.out.println("Failed to delete the file: " + filename);
            }
        } else {
            System.out.println("File does not exist: " + filename);
        }
    }

    // @Override
    // public void setServletContext(ServletContext servletContext) {
    //     this.servletContext = servletContext;
    //     this.uploadDir = servletContext.getContext();
       
    // }

}
