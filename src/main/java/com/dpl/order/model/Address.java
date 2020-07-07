package com.dpl.order.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Address implements Serializable {
	private static final long serialVersionUID = -9025687538939656535L;
	private String firstName;
	private String lastName;
	private String mobile;
	private String addressType;	
	private String companyName;
	private String line1;
	private String line2;
	private String city;
	private String postcode;
	private String country;
	private String lat;
	private String lang;
}
