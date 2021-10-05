package co.intrena.security;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtil {
	@Value("${security.jwt.secret}")
	private String key;
	
	@Value("${security.jwt.issuer}")
	private String issuer;
	
	@Value("${security.jwt.ttlMillis}")
	private long ttlMillis;
	
	public String crearToken(String id, String email) 
	{
		//Selecciona el algoritmo de generación del token
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		
		//Capturar momento de log
		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);
		
		//Aplicar clave secreta
		byte[] apiKeySecretByte = DatatypeConverter.parseBase64Binary(key);
		
		//Encriptar llave
		Key signingKey = new SecretKeySpec(apiKeySecretByte, signatureAlgorithm.getJcaName());
		
		//Conformar el token con sus tres partes
		JwtBuilder builder = Jwts.builder().setId(id).setIssuedAt(now).setSubject(email).setIssuer(issuer).signWith(signatureAlgorithm, signingKey);
		
		if (ttlMillis >= 0)
		{
			long expMillis = nowMillis + ttlMillis;
			Date exp = new Date(expMillis);
			builder.setExpiration(exp);
		}
		
		//Construye jwt serializable ya compacto - URL guardada como String
		return builder.compact();
	}
	
	//Lee y valida el email del jwt
	public String getValue(String jwt)
	{
		//Valida un jws firmado o si no genera una excepción
		Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(key)).parseClaimsJws(jwt).getBody();
		
		return claims.getSubject();
	}
	
	
}
