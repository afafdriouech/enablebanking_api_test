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
