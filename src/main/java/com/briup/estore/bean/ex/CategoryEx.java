package com.briup.estore.bean.ex;

import java.util.List;
import com.briup.estore.bean.Category;

public class CategoryEx {
	private Integer id;

    private String name;

    private String description;

    private Integer parentId;
    
    /**
	  * 一级分类对应二级分类
	  */
	private List<Category> categories;
	 
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
}
