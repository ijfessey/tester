package com.fesco.SpringTemplate;

import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 *
 */
public class App 
{	
    public static void main( String[] args )
    {
    	// with authenticaiton http://stackoverflow.com/questions/21920268/basic-authentication-for-rest-api-using-spring-resttemplate
    	// http://www.baeldung.com/2012/04/16/how-to-use-resttemplate-with-basic-authentication-in-spring-3-1/
    	
    	// call test ip  http://ip.jsontest.com --> {"ip": "86.138.217.132"}
        RestTemplate restTemplate = new RestTemplate();

        // http://gturnquist-quoters.cfapps.io/api/random --> complex json {"type":"success","value":{"id":10,"quote":"Really loving Spring Boot, makes stand alone Spring apps easy."}}
        Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);        
        System.out.println(quote.toString());
    	
    	// call test ip  http://ip.jsontest.com --> {"ip": "86.138.217.132"}

        Result result = new Result();
        result.setId("AAA-ZZZ");
        result.setIp("111.222.444");
        
        result = restTemplate.getForObject("http://ip.jsontest.com", Result.class);
        System.out.println("Id = " + result.getId());
        System.out.println("Ip address = " + result.getIp());

        OuterResult outerResult = restTemplate.getForObject("http://ip.jsontest.com", OuterResult.class);
        System.out.println("Ip address = " + outerResult.getIp());
    }
}
