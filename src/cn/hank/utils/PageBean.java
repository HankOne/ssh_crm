package cn.hank.utils;

import java.util.List;

public class PageBean {

	// 当前页数
	private Integer currentPage;
	// 总记录数
	private Integer totalCount;
	// 每页显示条数
	private Integer pageSize;
	// 总页数
	private Integer totalPage;
	// 分页列表数据
	private List list;

	public PageBean(Integer currentPage, Integer totalCount, Integer pageSize) {
		System.out.println("初始化pageBean");

		this.currentPage = currentPage;
		this.totalCount = totalCount;
		this.pageSize = pageSize;

		
		if (this.currentPage == null) {
			this.currentPage = 1;
		}
		if (this.pageSize == null) {
			this.pageSize = 3;
		}
		// 计算总页数
		// this.totalPage=(int) Math.ceil(this.totalCount/this.pageSize);
		this.totalPage = (this.totalCount + this.pageSize - 1) / this.pageSize;

		if (this.currentPage < 1) {
			this.currentPage = 1;
		}
		System.out.println("赋值2");	
		System.out.println(this.currentPage);
		System.out.println(this.totalPage);
		if (this.currentPage > this.totalPage) {
			this.currentPage = this.totalPage;
		}

		System.out.println("赋值202");

	}

	// 计算起始索引
	public int getStart() {
		return (this.currentPage - 1) * this.pageSize;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "PageBean [currentPage=" + currentPage + ", totalCount=" + totalCount + ", pageSize=" + pageSize
				+ ", totalPage=" + totalPage + ", list=" + list + "]";
	}

}