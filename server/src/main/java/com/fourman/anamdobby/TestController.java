package com.fourman.anamdobby;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/")
    String test() {
        return "server running";
    }

    @GetMapping("/json")
    ResponseEntity<String> test2() {
        return ResponseEntity.ok("json data");
    }
}
