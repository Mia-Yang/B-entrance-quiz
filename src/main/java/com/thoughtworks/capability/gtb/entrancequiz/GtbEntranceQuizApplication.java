package com.thoughtworks.capability.gtb.entrancequiz;

import domain.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@SpringBootApplication
public class GtbEntranceQuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(GtbEntranceQuizApplication.class, args);
	}

	private List<Person> nameList= initList();

	private List<Person> initList() {
		List<Person> nameList= new ArrayList<>();
		nameList.add(new Person(1, "杨思雨"));
		nameList.add(new Person(2, "姚明"));
		nameList.add(new Person(3, "贠晨曦"));
		return nameList;
	}

    @GetMapping("/group/nameList")
	public List<Person> getNameList() {return nameList;}

	@PostMapping("/group/person")
	public void addPerson(@RequestBody Person person) {
		nameList.add(person);
	}
}
