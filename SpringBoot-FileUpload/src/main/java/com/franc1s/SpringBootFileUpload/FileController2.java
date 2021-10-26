package com.franc1s.SpringBootFileUpload;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@RestController
public class FileController2 {

    SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/");

    //单文件上传
    @PostMapping("/upload2")
    public void upload(MultipartFile[] files, HttpServletRequest request) throws IOException {
        String realPath = request.getServletContext().getRealPath("/");
        String format=sdf.format(new Date());
        String path = realPath+format;
        java.io.File file1=new java.io.File(path);
        if (!file1.exists()){
            file1.mkdirs();
        }
        for (MultipartFile file : files) {
            String originalFilename = file.getOriginalFilename();
            String newName = UUID.randomUUID().toString() + originalFilename.substring(originalFilename.lastIndexOf("."));
            file.transferTo(new java.io.File(file1,newName));
            String s = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + format + newName;
            System.out.println(s);
        }
    }
}
