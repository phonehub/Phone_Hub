package cn.edu.zhku.phonehub.order.model;

import java.util.ArrayList;

public class PageBean {

	private int curPage;						//当前页数
	private int totalPages;						//总页数
	private int totalRows;						//总行数
	private int pageSize;						//每页显示行数
	private ArrayList<StoreSeeOrder> data;		//每页显示的数据 不使用
	
	public int getCurPage(){
//		if(curPage>getTotalPages()){
//			curPage = getTotalPages();
//		}
//		else if(curPage<1){
//			curPage = 1;
//		}
		return curPage;
	}

	
	public PageBean() {
		super();
	}



	public int getTotalPages() {
		if(totalRows%pageSize==0){
			totalPages = totalRows/pageSize;
		}
		else{
			totalPages = totalRows/pageSize+1;
		}
		
		return totalPages;
	}

	@Override
	public String toString() {
		return "PageBean [curPage=" + curPage + ", totalPages=" + totalPages
				+ ", totalRows=" + totalRows + ", pageSize=" + pageSize + "]";
	}


	public int getTotalRows() {
		return totalRows;
	}

	public int getPageSize() {
		return pageSize;
	}

	public ArrayList<StoreSeeOrder> getData() {
		return data;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setData(ArrayList<StoreSeeOrder> data) {
		this.data = data;
	}
	
	
}
