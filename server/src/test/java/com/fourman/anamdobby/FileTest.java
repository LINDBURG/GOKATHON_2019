package com.fourman.anamdobby;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FileTest {
    @Test
    @DisplayName("프로필 이미지 파일을 가져오는지 확인")
    void getFile() throws FileNotFoundException {
        File file = ResourceUtils.getFile("classpath:static/images/profile1.jpg");
        assertNotNull(file);
    }
}
