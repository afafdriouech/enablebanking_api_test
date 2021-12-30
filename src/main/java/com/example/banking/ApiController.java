package com.example.banking;

import java.util.Collections;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

public class ApiController {
	
	public static String connect()
	{
		String token="eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6ImNhMjE0MzYxLWMyZmMtNDg3NS04YzdkLTI2NWEwMjgyOGIxMCJ9.eyJpc3MiOiJlbmFibGViYW5raW5nLmNvbSIsImF1ZCI6ImFwaS50aWxpc3kuY29tIiwiaWF0IjoxNjQwODE4ODAwLCJleHAiOjE2NDA5MDUwMDB9.kDvW0mqJVEa7HOgXYYBFoAPjipHkhHfdNUR3ZpFeldrrsAmMfsoJRvuPiJxQE-T50lyaNVA7xiYY6VfF_10ATDWoGC47ZOInhOyIIZnRspxGIavYiPF0zfaAu6vyztIHOHKd40m7oMH-UjLIyWeaXXxPV-KwXyd3K4krOK8J22Ykk9dGnQae9NSUeVeP11pO-KAL_4YH0coj8xgCXT0YHAy1-Tymjb1zFh185YfPV8SvE--ILuh4w20RMbe5lMsqNHLVlTbt4srwsLZIUEP3GlVzs7NHrhR_f8nefqFfbrRi4yRr6VfSWke2Y32009mE1qmuSvrcBI33C2XuSumVnqimIqIkAmUL7nHeqBgnDMFcSfLbQHj8E9mhiXORXJGv_3-yCjU-PzBxXQuiWe4bscvtVilBeYRum-11pMYl_iR9T1R9kEjzwdezs0DRSDhZv0jj5i26IiJOWiM4XXhaRYf_pXPvFOxMMsjLAAvvI49laC1K4h3QRu6uDAZr9VSheDNA77SVdTC-RHvA3vSGczIoVCn3-S6mThnuMGEnOPWGW12ajfHXAhPWpOH70JvGaDENuVvPxG8P32PuU6erki1Wt-MvsHzI05zNVnveOFzXvlO6H6g1beVcnJLN6X4uGDZVCFOCpFHLSnuDEx_dSDJp48WVT0wY5yQpI-zD028";
		String url="https://api.tilisy.com/aspsps";
		//String url="api.tilisy.com/aspsps";
	    HttpHeaders headers=new HttpHeaders();  
		headers.set("Authorization", "Bearer "+ token);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity=new HttpEntity<String>(headers);
		RestTemplate restTemplate= new RestTemplate();
		/*String rates = restTemplate.getForObject(url,String.class,entity);
		return rates;*/
		
		ResponseEntity<String> response = restTemplate.exchange(
			    url, HttpMethod.GET, entity, String.class);
		//response.
		return response.getBody();
	}
}
