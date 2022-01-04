package com.example.banking.models;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

import io.jsonwebtoken.Jwts;
import org.apache.tomcat.util.codec.binary.Base64;
import org.json.JSONObject;


public class JwtClass {

	
	private final static int EXPIRY_DAYS = 1;
	private final static String app_id="ca214361-c2fc-4875-8c7d-265a02828b10";
	static File secretKeyF = new File("C:\\Users\\lenovo\\eclipse-workspace\\enableBanking\\ca214361-c2fc-4875-8c7d-265a02828b10.pem");//rsa key file path
	
	public static String generateJWT() throws Exception
	{
		JSONObject jwtHeader = new JSONObject();
		jwtHeader.put("typ", "JWT");
		jwtHeader.put("alg", "RS256");
		jwtHeader.put("kid", app_id);		
		
		JSONObject jwtPayload = new JSONObject();
		jwtPayload.put("iss", "enablebanking.com");
		jwtPayload.put("aud", "api.tilisy.com");
		LocalDateTime ldt= LocalDateTime.now();
		jwtPayload.put("iat", ldt.toEpochSecond(ZoneOffset.UTC));
		LocalDateTime ldtExp = ldt.plusDays(EXPIRY_DAYS);
		jwtPayload.put("exp", ldtExp.toEpochSecond(ZoneOffset.UTC)); 

		RSAPrivateKey key= readPrivateKey(secretKeyF);
		
		String jws = Jwts.builder()
				  .setHeaderParam("typ", "JWT")
				  .setHeaderParam("alg", "RS256")
				  .setHeaderParam("kid", app_id)
				  .setIssuer("enablebanking.com")
				  .setAudience("api.tilisy.com")
				  .setIssuedAt(Date.from(Instant.ofEpochSecond(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC))))
				  .setExpiration(Date.from(Instant.ofEpochSecond(LocalDateTime.now().plusDays(EXPIRY_DAYS).toEpochSecond(ZoneOffset.UTC))))
				  .signWith(key)
				  .compact();
		return jws;
	}


	public static RSAPrivateKey readPrivateKey(File file) throws Exception {
	    String key = new String(Files.readAllBytes(file.toPath()), Charset.defaultCharset());

	    String privateKeyPEM = key
	      .replace("-----BEGIN PRIVATE KEY-----", "")
	      .replaceAll(System.lineSeparator(), "")
	      .replace("-----END PRIVATE KEY-----", "");

	    byte[] encoded = Base64.decodeBase64(privateKeyPEM);

	    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
	    PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(encoded);
	    return (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
	}
	
	
}
