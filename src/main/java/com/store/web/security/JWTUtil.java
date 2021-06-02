package com.store.web.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTUtil {

    private static final String KEY = "12345";

    public String generateToken(UserDetails userDetails) {
        return Jwts.builder().setSubject(userDetails.getUsername()) //Debemos pasar como parametros: Usuario
                .setIssuedAt(new Date()) //Fecha de creación "Hoy"
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 10)) //Fecha de expiración, fecha actual sumado a 100 sec * 60 min * 10 days
                .signWith(SignatureAlgorithm.HS256, KEY).compact(); //La firma del token, SignatureAlgorithm de la propia libreria y la llave, finalmente solo lo compactamos y ya está
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        return userDetails.getUsername().equals(extractUsername(token)) && !isTokenExpired(token);
    }

    public String extractUsername(String token) {
        return getClaims(token).getSubject();
    }

    public boolean isTokenExpired(String token) {
        return getClaims(token).getExpiration().before(new Date()); //Validamos que la fecha esté antes de la fecha actual con .before, de lo contrario ya expiró
    }

    //Los claims son los datos que vienen dentro del token
    private Claims getClaims(String token) {
        return Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
    }
}
