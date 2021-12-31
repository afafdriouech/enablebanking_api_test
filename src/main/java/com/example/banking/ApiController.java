package com.example.banking;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.banking.models.ASPSP;
import com.example.banking.models.Access;
import com.example.banking.models.AuthentUrl;
import com.example.banking.models.Code;
import com.example.banking.models.Root;
import com.example.banking.models.Session;
import com.example.banking.models.Transaction;
import com.example.banking.models.Transactions;
import com.example.banking.models.UrlResponse;

public class ApiController {
	
	private static String token="eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6ImNhMjE0MzYxLWMyZmMtNDg3NS04YzdkLTI2NWEwMjgyOGIxMCJ9."
			+ "eyJpc3MiOiJlbmFibGViYW5raW5nLmNvbSIsImF1ZCI6ImFwaS50aWxpc3kuY29tIiwiaWF0IjoxNjQwOTM0MDEwLCJleHAiOjE2NDEwMjA0MDB9."
			+ "hRvkLjl7wR0Ct7aACgWNkSruGhW-T67Y0eg4Kr1vdLq0yzWYyTGHWY9qtp6l9z-DmTXCp0dULsw-_I7kvUJ8CThMR-V7Vr48bCiaPU9-zjvJUDVA6ndy5sSBv"
			+ "_A_JyD3mNjvVwV63iYg0haD91VWgK6WcI2vbLpGGY9mt2hM_4riCm_yzC7W4Tg_Hc7xaFbAMP3SWTYdt9bH0qWQxvYTe5a17ODRkPZ_Qy75foXlErk5C7xOVE9U8uDjzmFiBphn44wc5P04_joylBtxe4_3iUT32TNoVXBoMRAw-W0EuYjDtlNHRUHChEmYyTV50V3QE75V6iOlNz7XYnE0zEMZ5xLzbNEpbG4UCKT8nSzDjz_POXKQpcGCEVI2a_RTSJLt5nSEyXFRaFnmnvKkDKRfwuzYRIuLRM1o8qb4p77hyc0hfEvi2JObtNOiGh7mT5Fid13X3f0HvRTt_sdX7wDH-UeAc1oNLJADTMxqXnMn1WHSnB1WuE1f32mv49b2FL8Z9QXztJJv8AoYDKA5Z355TV3gZiu_LMq5ei0QmvWXxDyxAe7AKRM4u7eQDuSyrS4k68yxNNtW-TvX1DFwGC2IiaMQUe3aqkiE4e7LqzhNVDFvREcVnFTP6osoa_9n-ekl8kY-oQq7iysxLyos-WKosjNOeevF2qBwbLlRdGNYOoM";
	
	public static Root banksList() throws Exception
	{
		String url="https://api.tilisy.com/aspsps";
	    HttpHeaders headers=new HttpHeaders();  
		headers.set("Authorization", "Bearer "+ token);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity=new HttpEntity<String>(headers);
		RestTemplate restTemplate= new RestTemplate();
		
		ResponseEntity<Root> response = restTemplate.exchange(
		    url, HttpMethod.GET, entity, new ParameterizedTypeReference<Root>() {});
		if(response.getStatusCode().value()!=200)
			throw new Exception("no available aspsps");
		Root root=response.getBody();
        //List<ASPSP> banks= root.getAspsps();
		return root;
	}
	
	public static String getAuthLink(String bankName,String country) throws Exception
	{
		String url="https://api.tilisy.com/auth";
	    HttpHeaders headers=new HttpHeaders();  
		headers.set("Authorization", "Bearer "+ token);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		ZonedDateTime dateTime = ZonedDateTime.now().plus(1, ChronoUnit.MONTHS);
		
		Access access=new Access(dateTime);
		ASPSP aspsp=new ASPSP(bankName,country);
		String state="3a57e2d3-2e0c-4336-af9b-7fa94f0606a3";
		String redirect_url="https://www.nordea.fi/";
		AuthentUrl auth=new AuthentUrl(access,aspsp,state,redirect_url);
		
		HttpEntity<AuthentUrl> entity=new HttpEntity<>(auth,headers);
		RestTemplate restTemplate= new RestTemplate();
		
		ResponseEntity<UrlResponse> response = restTemplate.exchange(
		    url, HttpMethod.POST, entity, new ParameterizedTypeReference<UrlResponse>() {});
		
		if(response.getStatusCode().value()!=200)
			throw new Exception("can't generate the url");
		return response.getBody().getUrl();
	}
	
	public static String createSession(String sessionCode) throws Exception
	{
		String url="https://api.tilisy.com/sessions";
		Code code=new Code(sessionCode);

	    HttpHeaders headers=new HttpHeaders();  
		headers.set("Authorization", "Bearer "+ token);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		
		HttpEntity<Code> entity=new HttpEntity<>(code,headers);
		RestTemplate restTemplate= new RestTemplate();
		
		ResponseEntity<Session> response = restTemplate.exchange(
		    url, HttpMethod.POST, entity, new ParameterizedTypeReference<Session>() {});
		if(response.getBody().getAccounts().size()==0)
			throw new Exception("No accounts");
		else
			return response.getBody().getAccounts().get(0).getUid();
	}
	
	public static ArrayList<Transaction> getTransactions(String accountUid) throws Exception
	{
		String url="https://api.tilisy.com/accounts/"+accountUid+"/transactions";
	    HttpHeaders headers=new HttpHeaders();  
		headers.set("Authorization", "Bearer "+ token);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		
		LocalDate date_from= LocalDate.now().minus(1, ChronoUnit.MONTHS);
		HttpEntity<LocalDate> entity=new HttpEntity<LocalDate>(date_from,headers);
		RestTemplate restTemplate= new RestTemplate();
		ResponseEntity<Transactions> response = restTemplate.exchange(url, HttpMethod.GET, entity, new ParameterizedTypeReference<Transactions>() {});
		if(response.getStatusCode().value()!=200)
			throw new Exception("can't fetch transactions");
		return (ArrayList<Transaction>) response.getBody().getTransactions();
	}
}
