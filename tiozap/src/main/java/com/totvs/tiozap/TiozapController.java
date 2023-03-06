package com.totvs.tiozap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class TiozapController {

    @GetMapping("hello")
    public String dizereHello() {
        return "Hello Kitty";
    }

    @GetMapping("/data")
    public LocalDate mostrarData() {
        return LocalDate.now();
    }
}
