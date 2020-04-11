package com.how2java.service;

import com.how2java.controller.CategoryController;
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
public class CategoryServiceTest {

    @Before
    public void setUp() throws Exception {
    }

    @Autowired
    private CategoryController controller;

    @Autowired
    private Page page;

    @Test
    public void testlist() {
        controller.listCategory(page);
    }
}