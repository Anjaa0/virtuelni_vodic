package me.fit.rest;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class IpLog {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ipLog_seq")
	private Long id;
    private String ipString;
    private String ipType;
    private Date createdDate;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getIpString() {
		return ipString;
	}
	public void setIpString(String ipString) {
		this.ipString = ipString;
	}
	public String getIpType() {
		return ipType;
	}
	public void setIpType(String ipType) {
		this.ipType = ipType;
	}
	public IpLog(Long id, String ipString, String ipType, Date createdDate) {
		super();
		this.id = id;
		this.ipString = ipString;
		this.ipType = ipType;
		this.createdDate = createdDate;
	}
	public IpLog() {
		super();
	}

    
    
    
    
}
