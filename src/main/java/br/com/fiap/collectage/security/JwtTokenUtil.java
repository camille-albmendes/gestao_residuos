package br.com.fiap.collectage.security;

public class JwtTokenUtil {

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;

    public class JwtTokenUtil {

        private String secretKey = "mySecretKey"; // Deve ser armazenado em local seguro

        public String generateToken(String username) {
            return Jwts.builder()
                    .setSubject(username)
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1 dia de expiração
                    .signWith(SignatureAlgorithm.HS512, secretKey)
                    .compact();
        }

        public String getUsernameFromToken(String token) {
            return Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
        }
    }
}
