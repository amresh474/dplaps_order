package com.dpl.order.properties;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Configuration
@PropertySource(value = "classpath:codes.json", factory = JsonPropertySourceFactory.class)
@ConfigurationProperties
public class Codes {

	private Map<String, ?> CODE_10200;
	private Map<String, ?> CODE_10202;
	private Map<String, ?> CODE_10204;
	private Map<String, ?> CODE_10201;
	private Map<String, ?> CODE_10400;
	private Map<String, ?> CODE_10401;
	private Map<String, ?> CODE_10403;
	private Map<String, ?> CODE_10404;
	private Map<String, ?> CODE_10405;
	private Map<String, ?> CODE_10406;
	private Map<String, ?> CODE_10409;
	private Map<String, ?> CODE_10410;
	private Map<String, ?> CODE_10415;
	private Map<String, ?> CODE_10429;
	private Map<String, ?> CODE_10422;
	private Map<String, ?> CODE_10500;
	private Map<String, ?> CODE_10020;
	private Map<String, ?> CODE_10021;
	private Map<String, ?> CODE_10022;
	private Map<String, ?> CODE_10023;
	private Map<String, ?> CODE_10024;
	private Map<String, ?> CODE_10025;
	private Map<String, ?> CODE_10026;
	private Map<String, ?> CODE_10027;
	private Map<String, ?> CODE_10028;
	private Map<String, ?> CODE_10029;
	private Map<String, ?> CODE_10030;
	private Map<String, ?> CODE_10031;
	private Map<String, ?> CODE_10032;
	private Map<String, ?> CODE_10043;
	private Map<String, ?> CODE_10044;

}