package user.zc.spider.entity;

import java.util.Date;

import user.zc.spider.model.BaseEntity;

public class DoubanBook extends BaseEntity{
	private String book_id = "";
	private String title= "";
	private String author = "";
	private String book_site= "";
	private String nationality= "";
	private String release_date= "";
	private Float rate  = 0.0f;
	private Integer rating_people= 0;
	private String book_pic_path= "";
	private String synopsis;
	private String book;
	private String e_book;
	private Integer version;
	public String getBook_id() {
		return book_id;
	}
	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getBook_site() {
		return book_site;
	}
	public void setBook_site(String book_site) {
		this.book_site = book_site;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getRelease_date() {
		return release_date;
	}
	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}
	public Float getRate() {
		return rate;
	}
	public void setRate(Float rate) {
		this.rate = rate;
	}
	public Integer getRating_people() {
		return rating_people;
	}
	public void setRating_people(Integer rating_people) {
		this.rating_people = rating_people;
	}
	public String getBook_pic_path() {
		return book_pic_path;
	}
	public void setBook_pic_path(String book_pic_path) {
		this.book_pic_path = book_pic_path;
	}
	public String getSynopsis() {
		return synopsis;
	}
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	public String getBook() {
		return book;
	}
	public void setBook(String book) {
		this.book = book;
	}
	public String getE_book() {
		return e_book;
	}
	public void setE_book(String e_book) {
		this.e_book = e_book;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	
	
	
	
	
}