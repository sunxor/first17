package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class DemoController {

    @GetMapping
    public ResponseEntity<String> getValue(@RequestParam(required = true, value = "attr") Object attr,
                                           @RequestParam(required = true, value = "attr") Object attr1) {
        switch (attr) {
            case null, String s -> {
                log.info("Value - {}", s);
            }
            case Integer i -> {
                String.valueOf(i);
            }
            case Double d -> String.valueOf(d);
            default -> throw new IllegalStateException("Unexpected err: " + attr);
        }
        return ResponseEntity.ok(attr.toString());
    }
}
