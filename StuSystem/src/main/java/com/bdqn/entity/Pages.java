package com.bdqn.entity;

import java.util.List;

public class Pages {
	private int current_page = 1;
	private int total_page = 1;
	private int count = 1;
	private int page_size;
	private List<Standard> list;
	public int getCurrent_page() {
		return current_page;
	}
	public void setCurrent_page(int current_page) {
		total_page = count%page_size ==0?count/page_size:count/page_size+1;
		this.current_page = current_page;
	}
	public int getTotal_page() {
		return total_page;
	}
	public void setTotal_page(int total_page) {
		this.total_page = total_page;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPage_size() {
		return page_size;
	}
	public void setPage_size(int page_size) {
		this.page_size = page_size;
	}
	public List<Standard> getList() {
		return list;
	}
	public void setList(List<Standard> list) {
		this.list = list;
	}
	
}
