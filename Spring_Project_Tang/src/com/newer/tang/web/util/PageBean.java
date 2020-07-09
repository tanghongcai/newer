package com.newer.tang.web.util;


import java.util.List;

public class PageBean<T> {
	private List<T> data;
	private int count;//��������
	private int pageNo;//��ǰҳ��
	private int pageSize;//ҳ���С
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
	//��ȡ��¼����
	public int getCount() {
		return this.count;
	}
	//��ȡ��ҳ����ҳ��
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
	//��ȡ��ҳ
		public int getFirstPage(){
			return 1;
		}
		//��ȡβҳ
		public int getLastPage(){
			//���û�м�¼����ʾ��һҳ
			if(this.count==0){
				return 1;
			}
			return this.getTotalPages();
		}
		//��ȡ��һҳ
		public int getPreviousPage(){
			if(this.pageNo==1){
				return 1;
			}
			return this.pageNo-1;
		}
		//��ȡ��һҳ
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
