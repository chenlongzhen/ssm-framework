package com.how2java.controller;

import com.how2java.util.Page;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test/test.xml")
public class CategoryControllerTest {

    @Autowired
    CategoryController controller;

    @Autowired
    Page page;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void listCategory() {
        controller.listCategory(page);
    }
}