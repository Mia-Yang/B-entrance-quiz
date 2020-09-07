package com.thoughtworks.capability.gtb.entrancequiz.api;

import domain.Person;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:1234")
public class PersonApi {

    private List<Person> nameList= initList();

    private List<Person> initList() {
        List<Person> nameList= new ArrayList<>();
        List<String> names = Arrays.asList(
                "廖浚斌", "沈乐棋", "徐慧慧", "陈思聪", "王江林", "王登宇", "杨思雨", "江雨舟",
                "廖燊", "胡晓", "但杰", "盖迈达","肖美琦", "黄云洁", "齐瑾浩", "刘亮亮","肖逸凡",
                "王作文", "郭瑞凌", "李明豪", "党泽", "肖伊佐", "贠晨曦", "李康宁", "童世祁", "马庆", "商婕",
                "余榕", "谌哲", "董翔锐", "陈泰宇", "赵允齐", "张柯", "廖文强", "何力", "岳港", "凌凤仪");
        for (int i = 0; i < names.size(); i++ ) {
            nameList.add(new Person(i+1, names.get(i)));
        }
        return nameList;
    }

    @GetMapping("/list")
    public List<Person> getNameList() {return nameList;}

    @PostMapping("/list")
    public void addPerson(@RequestBody String inputName) {
        nameList.add(new Person(nameList.size()+1, inputName));
    }

}
