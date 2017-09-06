package com.example.website

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
public class DataController {
    @RequestMapping("/data/list")
    public Object getList(@RequestParam(value = "name", defaultValue = "World") String name) {
        return [
            name: name,
            items: [
            [a: 1, b: 2],
            [a: 3, b: 4],
        ]]
    }
}
