package com.hhj.crm.serve.domain;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by Hongjian_He on 2017/6/16.
 */
@Data
@Entity
@Table(name="test")
public class Test {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @Column
    private String name ;
    @Column
    private Integer age;

    public Test(long id) {
        this.id = id;
    }

    public Test(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
