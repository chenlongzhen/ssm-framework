package com.how2java.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.how2java.pojo.Category;
import com.how2java.service.CategoryService;
import com.how2java.util.Page;

// 告诉spring mvc这是一个控制器类
@Controller
@RequestMapping("")
public class CategoryController {
	@Autowired
	CategoryService categoryService;

	@RequestMapping("/listCategory")
	public ModelAndView listCategory(Page page){
		ModelAndView mav = new ModelAndView();
		PageHelper.offsetPage(page.getStart(),5);
		List<Category> cs= categoryService.list();
		int total = (int) new PageInfo<>(cs).getTotal();
		
		page.caculateLast(total);
		
		// 放入转发参数
		mav.addObject("cs", cs);
		// 放入jsp路径
		mav.setViewName("listCategory");
		return mav;
	}

	/**
	https://www.cnblogs.com/hemiy/p/6228623.html
	*/
	@RequestMapping("/echart1")
    @ResponseBody //https://www.cnblogs.com/mengtaoadmin/p/11184014.html!!!!TODO!!!!
	public Object listCategoryEchart(Page page){

		Map<String, Object> map = new HashMap<String, Object>();

		List<Float> clist1 = new ArrayList<Float>();
		List<Category> cs= categoryService.list();

		for(Category cl : cs) {
			clist1.add(Float.valueOf(cl.getId()));
		}

		map.put("c_eva", clist1);
		map.put("c_rain", clist1);
		map.put("c_avgt", clist1);
		map.put("success1", true);

		return map;
	}

}
