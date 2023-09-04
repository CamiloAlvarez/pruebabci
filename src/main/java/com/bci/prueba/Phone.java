package com.bci.prueba;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Phone {
	private @Id @GeneratedValue Long id;
	private String number;
	private String citycode;
	private String countrycode;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Usuario user;
	
	public Long getId() {
	    return this.id;
	}
	
	public String getNumber() {
		return this.number;
    }

    public String getCitycode() {
    	return this.citycode;
    }
    
    public String getCountrycode() {
    	return this.countrycode;
    }
    
    public Usuario getUser() {
    	return this.user;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public void setNumber(String number) {
    	this.number = number;
    }
    
    public void setCitycode(String citycode) {
    	this.citycode = citycode;
    }
    
    public void setCountrycode(String countrycode) {
    	this.countrycode = countrycode;
    }
    
    public void setUser(Usuario user) {
    	this.user = user;
    }
}
