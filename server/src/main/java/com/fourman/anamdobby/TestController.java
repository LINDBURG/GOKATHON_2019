package com.fourman.anamdobby;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/test")
    String test() {
        return "server connected";
    }
}
