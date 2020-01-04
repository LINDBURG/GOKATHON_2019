package com.fourman.anamdobby.controller;

import com.fourman.anamdobby.dto.DobbyResponseDto;
import com.fourman.anamdobby.service.DobbyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DobbyController {
    private DobbyService dobbyService;

    public DobbyController(DobbyService dobbyService) {
        this.dobbyService = dobbyService;
    }

    @GetMapping("/dobbys/this-month")
    ResponseEntity<List<DobbyResponseDto>> getDobbysOfTheMonth() {
        return ResponseEntity.ok(dobbyService.findAllDobbys());
    }

    @GetMapping("/dobbys/{naverId}")
    ResponseEntity<DobbyResponseDto> getDobbyProfile(@PathVariable String naverId) {
        return ResponseEntity.ok(dobbyService.findDobbyById(naverId));
    }

    @GetMapping("/dobbys/{naverId}/reviews")
    ResponseEntity<List<String>> getDobbyReviews(@PathVariable String naverId) {
        return ResponseEntity.ok(dobbyService.findAllReviewById(naverId));
    }

    @PostMapping("/dobbys/{naverId}/orders/{orderId}")
    ResponseEntity applyOrder(@PathVariable String naverId, @PathVariable long orderId) {
        dobbyService.applyOrder(naverId, orderId);
        return ResponseEntity.ok().build();
    }
}
