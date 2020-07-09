package com.newer.tang.web.util;


import java.util.List;

public class PageBean<T> {
	private List<T> data;
	private int count;//内容总数
	private int pageNo;//当前页号
	private int pageSize;//页面大小
	public PageBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	//获取记录总数
	public int getCount() {
		return this.count;
	}
	//获取分页的总页数
	public int getTotalPages() {
		return (this.count + this.pageSize - 1) / this.pageSize;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	//获取首页
		public int getFirstPage(){
			return 1;
		}
		//获取尾页
		public int getLastPage(){
			//如果没有记录则显示第一页
			if(this.count==0){
				return 1;
			}
			return this.getTotalPages();
		}
		//获取上一页
		public int getPreviousPage(){
			if(this.pageNo==1){
				return 1;
			}
			return this.pageNo-1;
		}
		//获取下一页
		public int getNextPage(){
			if(this.pageNo==this.getLastPage()){
				return this.pageNo;
			}
			return this.pageNo+1;
		}
	@Override
	public String toString() {
		return "PageBean [data=" + data + ", count=" + count + ", pageNo="
				+ pageNo + ", pageSize=" + pageSize + "]";
	}
	
}
