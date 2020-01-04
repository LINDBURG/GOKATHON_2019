package com.fourman.anamdobby.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

@Service
@Transactional
public class FileService {
    public File getProfileImage(String fileName) {
        try {
            File file = ResourceUtils.getFile("classpath:static/images/" + fileName);
            //IOUtils.toByteArray();
            return file;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(fileName + "을 찾지 못했습니다.");
        }
    }
}
