package ru.students.StartupTeam.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Date;

@Service
public class JWTService {
    @Value("${jwt.jwtSecret}")
    private String secret;
    @Value("${jwt.jwtExpirationMinutes}")
    private int jwtExpirationMinutes;

    public String generateJwtToken(String email) {
        Date expirationDate = Date.from(ZonedDateTime.now().plusMinutes(jwtExpirationMinutes).toInstant());

        return JWT.create()
                .withSubject("Person details")
                .withClaim("email", email)
                .withIssuer("startup-team")
                .withIssuedAt(new Date())
                .withExpiresAt(expirationDate)
                .sign(Algorithm.HMAC256(secret));
    }

    public String validateTokenAndRetrieveClaim(String token) throws JWTVerificationException {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret))
                .withSubject("Person details")
                .withIssuer("startup-team")
                .build();

        DecodedJWT jwt = verifier.verify(token);
        return jwt.getClaim("email").asString();
    }
}
