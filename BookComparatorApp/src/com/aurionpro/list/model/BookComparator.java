package com.aurionpro.list.model;

import java.util.Comparator;

public class BookComparator {
	public static class BookTitleComparator implements Comparator<Book>{
		@Override
		public int compare(Book o1, Book o2) {
			return o1.getTitle().compareTo(o2.getTitle());
		}
	}
	public static class BookAuthorComparator implements Comparator<Book>{
		@Override
		public int compare(Book o1, Book o2) {
			return o1.getAuthor().compareTo(o2.getAuthor());
		}
	}
	public static class BookPriceComparator implements Comparator<Book>{
		@Override
		public int compare(Book o1, Book o2) {
			return o1.getPrice().compareTo(o2.getPrice());
		}
	}
	public static class BookPublishicanYearComparator implements Comparator<Book>{
		@Override
		public int compare(Book o1, Book o2) {
			return o1.getPublicationYear().compareTo(o2.getPublicationYear());
		}
	}
}
