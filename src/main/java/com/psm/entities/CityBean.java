package com.psm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "cityinfo")
public class CityBean {

	@Id
	@GeneratedValue
	private int city_id;

	@Column(name = "city_name")
	private String cityName;

	public int getCity_id() {
		return city_id;
	}

	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	@Override
	public String toString() {
		return "StateBean [city_id=" + city_id + ", cityName=" + cityName + "]";
	}

}
