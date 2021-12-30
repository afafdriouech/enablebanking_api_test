package com.example.banking;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.banking.models.ASPSP;
import com.example.banking.models.Access;
import com.example.banking.models.AuthentUrl;
import com.example.banking.models.Bank;
import com.example.banking.models.Banks;
import com.example.banking.models.Root;
import com.example.banking.models.UrlResponse;

public class ApiController {
	
	public static LinkedHashSet<String> banksList()
	{
		String token="eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6ImNhMjE0MzYxLWMyZmMtNDg3NS04YzdkLTI2NWEwMjgyOGIxMCJ9.eyJpc3MiOiJlbmFibGViYW5raW5nLmNvbSIsImF1ZCI6ImFwaS50aWxpc3kuY29tIiwiaWF0IjoxNjQwODE4ODAwLCJleHAiOjE2NDA5MDUwMDB9.kDvW0mqJVEa7HOgXYYBFoAPjipHkhHfdNUR3ZpFeldrrsAmMfsoJRvuPiJxQE-T50lyaNVA7xiYY6VfF_10ATDWoGC47ZOInhOyIIZnRspxGIavYiPF0zfaAu6vyztIHOHKd40m7oMH-UjLIyWeaXXxPV-KwXyd3K4krOK8J22Ykk9dGnQae9NSUeVeP11pO-KAL_4YH0coj8xgCXT0YHAy1-Tymjb1zFh185YfPV8SvE--ILuh4w20RMbe5lMsqNHLVlTbt4srwsLZIUEP3GlVzs7NHrhR_f8nefqFfbrRi4yRr6VfSWke2Y32009mE1qmuSvrcBI33C2XuSumVnqimIqIkAmUL7nHeqBgnDMFcSfLbQHj8E9mhiXORXJGv_3-yCjU-PzBxXQuiWe4bscvtVilBeYRum-11pMYl_iR9T1R9kEjzwdezs0DRSDhZv0jj5i26IiJOWiM4XXhaRYf_pXPvFOxMMsjLAAvvI49laC1K4h3QRu6uDAZr9VSheDNA77SVdTC-RHvA3vSGczIoVCn3-S6mThnuMGEnOPWGW12ajfHXAhPWpOH70JvGaDENuVvPxG8P32PuU6erki1Wt-MvsHzI05zNVnveOFzXvlO6H6g1beVcnJLN6X4uGDZVCFOCpFHLSnuDEx_dSDJp48WVT0wY5yQpI-zD028";
		String url="https://api.tilisy.com/aspsps";
	    HttpHeaders headers=new HttpHeaders();  
		headers.set("Authorization", "Bearer "+ token);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity=new HttpEntity<String>(headers);
		RestTemplate restTemplate= new RestTemplate();
		
		//ResponseEntity<Banks> response = restTemplate.exchange(
		//    url, HttpMethod.GET, entity, new ParameterizedTypeReference<Banks>() {});
		/*ResponseEntity<Banks> response = restTemplate.exchange(
		    url, HttpMethod.GET, entity, Banks.class);
		Banks banks = response.getBody();
		//return banks.toString();
		return banks.getBank();*/
		
		ResponseEntity<Root> response = restTemplate.exchange(
		    url, HttpMethod.GET, entity, new ParameterizedTypeReference<Root>() {});
		Root root=response.getBody();
        
        StringBuffer banklist= new StringBuffer();
        LinkedHashSet<String> uniqueNames= new LinkedHashSet<String>();
        Iterator itr = root.getAspsps().iterator();     
        while (itr.hasNext()){
        	uniqueNames.add(itr.next().toString());
        }

        return uniqueNames;
	}
	
	public static String getAuthLink(String bankName)
	{
		String token="eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6ImNhMjE0MzYxLWMyZmMtNDg3NS04YzdkLTI2NWEwMjgyOGIxMCJ9.eyJpc3MiOiJlbmFibGViYW5raW5nLmNvbSIsImF1ZCI6ImFwaS50aWxpc3kuY29tIiwiaWF0IjoxNjQwODE4ODAwLCJleHAiOjE2NDA5MDUwMDB9.kDvW0mqJVEa7HOgXYYBFoAPjipHkhHfdNUR3ZpFeldrrsAmMfsoJRvuPiJxQE-T50lyaNVA7xiYY6VfF_10ATDWoGC47ZOInhOyIIZnRspxGIavYiPF0zfaAu6vyztIHOHKd40m7oMH-UjLIyWeaXXxPV-KwXyd3K4krOK8J22Ykk9dGnQae9NSUeVeP11pO-KAL_4YH0coj8xgCXT0YHAy1-Tymjb1zFh185YfPV8SvE--ILuh4w20RMbe5lMsqNHLVlTbt4srwsLZIUEP3GlVzs7NHrhR_f8nefqFfbrRi4yRr6VfSWke2Y32009mE1qmuSvrcBI33C2XuSumVnqimIqIkAmUL7nHeqBgnDMFcSfLbQHj8E9mhiXORXJGv_3-yCjU-PzBxXQuiWe4bscvtVilBeYRum-11pMYl_iR9T1R9kEjzwdezs0DRSDhZv0jj5i26IiJOWiM4XXhaRYf_pXPvFOxMMsjLAAvvI49laC1K4h3QRu6uDAZr9VSheDNA77SVdTC-RHvA3vSGczIoVCn3-S6mThnuMGEnOPWGW12ajfHXAhPWpOH70JvGaDENuVvPxG8P32PuU6erki1Wt-MvsHzI05zNVnveOFzXvlO6H6g1beVcnJLN6X4uGDZVCFOCpFHLSnuDEx_dSDJp48WVT0wY5yQpI-zD028";
		String url="https://api.tilisy.com/auth";
	    HttpHeaders headers=new HttpHeaders();  
		headers.set("Authorization", "Bearer "+ token);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		
		ZonedDateTime dateTime = ZonedDateTime.now().plus(1, ChronoUnit.DAYS);		
		
		Access access=new Access(dateTime);
		ASPSP aspsp=new ASPSP(bankName,"FI");
		String state="3a57e2d3-2e0c-4336-af9b-7fa94f0606a3";
		String redirect_url="https://www.nordea.fi/";
		AuthentUrl auth=new AuthentUrl(access,aspsp,state,redirect_url);
		
		HttpEntity<AuthentUrl> entity=new HttpEntity<>(auth,headers);
		RestTemplate restTemplate= new RestTemplate();
		

		ResponseEntity<UrlResponse> response = restTemplate.exchange(
		    url, HttpMethod.POST, entity, new ParameterizedTypeReference<UrlResponse>() {});
		//UrlResponse responseAuth=response.getBody();
		//return auth.getRedirect_url();
		//return responseAuth;
		return response.getBody().getUrl();
	}
}