package com.example.helper;

public class TestHelper {
	
	private static final String BASE_TITLE = "Sample-SNS";
	
	/** 正式なタイトルを返す */
	protected String fullTitle(String title) {
		if (!title.isBlank()) {
			return title + " | " + BASE_TITLE;			
		} else {
			return BASE_TITLE;
		}
	}

}
