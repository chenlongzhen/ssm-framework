package com.how2java.mapper;

import com.alibaba.fastjson.JSON;
import com.how2java.pojo.Category;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test/test.xml")

public class CategoryMapperTest {
// https://blog.csdn.net/hellozpc/article/details/80878563

    @Autowired
    private CategoryMapper categoryMapper;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void add() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void get() {
        Category c = categoryMapper.get(1);
        System.out.println(JSON.toJSONString(c));

        List<Category> all = categoryMapper.list();
        System.out.println(JSON.toJSONString(all));

    }

    @Test
    public void update() {
    }

    @Test
    public void list() {
    }
}