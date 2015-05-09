package com.tour.commons.global;

/**
 * pagebean
 * @author chenrh
 * @date 2015-5-8
 */
public class PageBean {

	private int currentPage;

	private int pageSize;

	private int limitStart;

	public int getLimitStart() {
		return limitStart;
	}

	public void setLimitStart(int limitStart) {
		this.limitStart = limitStart;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
