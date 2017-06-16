package com.hhj.crm.serve.domain;
import lombok.Data;
/**
 * Created by Hongjian_He on 2017/6/16.
 */
@Data
public class Test {

    private long id;
    private String name ;
    private Integer age;

    public Test(long id) {
        this.id = id;
    }

    public Test(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
