package com.franc1s.springbootfastdfs;

import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;

@SpringBootTest
class SpringBootFastDfsApplicationTests {

    @Test
    void contextLoads() throws MyException, IOException {
        ClientGlobal.initByProperties("fastdfs-client.properties");
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        StorageServer storageServer = null;
        StorageClient1 client = new StorageClient1(trackerServer, storageServer);
        NameValuePair pairs[] = null;
        String fileId = client.upload_file1("C:\\Users\\71495\\Desktop\\h12.jpg", "jpg", pairs);
        System.out.println(fileId);
    }

    @Test
    void download() throws IOException, MyException {
        ClientGlobal.initByProperties("fastdfs-client.properties");
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        StorageServer storageServer = null;
        StorageClient1 client = new StorageClient1(trackerServer, storageServer);
        byte[] bytes = client.download_file1("group1/M00/00/00/eBjfJGFiazuAfWuYAAJ6LnWhVv4131.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream(new File("C:\\Users\\71495\\Desktop\\javaboy.jpg"));
        fileOutputStream.write(bytes);
        fileOutputStream.close();
    }

    @Test
    void testToken() throws MyException, UnsupportedEncodingException, NoSuchAlgorithmException {
        int ts = (int) Instant.now().getEpochSecond();
        String token = ProtoCommon.getToken("M00/00/00/eBjfJGFiazuAfWuYAAJ6LnWhVv4131.jpg", ts, "FastDFS1234567890");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("http://120.24.223.36")
                .append("/group1/M00/00/00/eBjfJGFiazuAfWuYAAJ6LnWhVv4131.jpg")
                .append("?token=")
                .append(token)
                .append("&ts=")
                .append(ts);
        System.out.println(stringBuffer.toString());
    }

}
