package com.thoughtworks.capability.gtb.entrancequiz.api;

import domain.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonApi {

    private List<Person> nameList= initList();

    private List<Person> initList() {
        List<Person> nameList= new ArrayList<>();
        nameList.add(new Person(1, "杨思雨"));
        nameList.add(new Person(2, "姚明"));
        nameList.add(new Person(3, "贠晨曦"));
        return nameList;
    }

    @GetMapping("/list")
    public List<Person> getNameList() {return nameList;}

    @PostMapping("/list")
    public void addPerson(@RequestBody Person person) {
        nameList.add(person);
    }

}
