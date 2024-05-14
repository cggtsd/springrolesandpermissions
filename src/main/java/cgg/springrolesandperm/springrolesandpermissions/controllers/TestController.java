package cgg.springrolesandperm.springrolesandpermissions.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    
    @GetMapping("/roleHierarchy")
    public String test(){
        return "This is demo for role and privileges";
    }
}
