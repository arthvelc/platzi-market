package com.platzi.platzi.market.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HolaMundoController {

    @GetMapping("hola")
    public String grettings(){
        return "Hola, que tal";
    }
}
