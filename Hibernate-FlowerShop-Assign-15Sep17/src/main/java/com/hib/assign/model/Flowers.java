package com.hib.assign.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity(name = "FLOWERS")
public class Flowers implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@XmlElement
	@Id
	@GeneratedValue
	@Column(name = "FLOWER_ID")
	private int id;
	
	@XmlElement
	@Column(name = "FLOWER_NAME", length = 25)
	private String name;
	
	@XmlElement
	@Column(name = "FLOWER_TYPE", length = 25)
	private String type;
	
	public Flowers() {}

	public Flowers(String name, String type) {
		this.name = name;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Flowers [id=" + id + ", name=" + name + ", type=" + type + "]";
	}

}
