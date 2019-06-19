package com.tdd.tutorial.tdd;

import com.tdd.tutorial.app.domain.BookDTO;

public class BookDAOTestHelper {
	private BookDTO bookWithId1;

	public BookDAOTestHelper() {
		this.bookWithId1 = null;
		this.initData();
	}

	private void initData() {
		this.initBookWithId1();
	}

	private void initBookWithId1() {
		this.bookWithId1 = new BookDTO();
		this.bookWithId1.id = 1;
	}

	public BookDTO getBookWithId1() {
		return this.bookWithId1;
	}
}
