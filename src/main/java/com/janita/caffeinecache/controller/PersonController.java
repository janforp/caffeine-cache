package com.janita.caffeinecache.controller;

import com.janita.caffeinecache.bean.Person;
import com.janita.caffeinecache.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Janita on 2017/7/11- 17:25
 * 该类是:
 */
@RestController
@RequestMapping("/person")
@Api(value = "人")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    @ApiOperation(value = "添加")
    public Person add(@RequestBody Person person) {
        return personService.add(person);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "查询")
    public Person get(@PathVariable int id) {
        return personService.getPersonById(id);
    }
}
