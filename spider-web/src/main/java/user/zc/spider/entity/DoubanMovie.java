package user.zc.spider.entity;

import java.util.Date;

import user.zc.spider.model.BaseEntity;

public class DoubanMovie extends BaseEntity{
	private String movie_id = "";
	private String direct = "";
	private String title= "";
	private String scriptwriter= "";
	private String type= "";
	private String website= "";
	private String producer_area= "";
	private String language= "";
	private String release_date= "";
	private Integer film_length= 0;
	private String alias= "";
	private Float rate  = 0.0f;
	private Integer rating_people= 0;
	private String main_performer= "";
	private String IMDb= "";
	private Date create_time;
	private String movie_pic_path= "";
	private String color;
	private Integer film_total;
	private String synopsis;
	
	
	public String getSynopsis() {
		return synopsis;
	}
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	public Integer getFilm_total() {
		return film_total;
	}
	public void setFilm_total(Integer film_total) {
		this.film_total = film_total;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(String movie_id) {
		this.movie_id = movie_id;
	}
	public String getDirect() {
		return direct;
	}
	public void setDirect(String direct) {
		this.direct = direct;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getScriptwriter() {
		return scriptwriter;
	}
	public void setScriptwriter(String scriptwriter) {
		this.scriptwriter = scriptwriter;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getProducer_area() {
		return producer_area;
	}
	public void setProducer_area(String producer_area) {
		this.producer_area = producer_area;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getRelease_date() {
		return release_date;
	}
	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}
	public Integer getFilm_length() {
		return film_length;
	}
	public void setFilm_length(Integer film_length) {
		this.film_length = film_length;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
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
	public String getMain_performer() {
		return main_performer;
	}
	public void setMain_performer(String main_performer) {
		this.main_performer = main_performer;
	}
	public String getIMDb() {
		return IMDb;
	}
	public void setIMDb(String iMDb) {
		IMDb = iMDb;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public String getMovie_pic_path() {
		return movie_pic_path;
	}
	public void setMovie_pic_path(String movie_pic_path) {
		this.movie_pic_path = movie_pic_path;
	}
	
	
}