package ru.students.StartupTeam.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.students.StartupTeam.dto.PersonDTO;
import ru.students.StartupTeam.repositories.PeopleRepository;

import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class JWTService {
    @Value("${jwt.jwtSecret}")
    private String secret;
    @Value("${jwt.jwtExpirationMinutes}")
    private int jwtExpirationMinutes;
    private final PeopleRepository peopleRepository;
    private final PeopleService peopleService;

    public String generateJwtToken(String email) {
        Date now = new Date();
        Date expirationDate = Date.from(ZonedDateTime.now().plusMinutes(jwtExpirationMinutes).toInstant());

        return JWT.create()
                .withSubject(email)
                .withIssuer("startup-team")
                .withIssuedAt(now)
                .withExpiresAt(expirationDate)
                .sign(Algorithm.HMAC256(secret));
    }

    public Authentication validateToken(String token){
        Algorithm algorithm = Algorithm.HMAC256(secret);
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("startup-team")
                .build();
        DecodedJWT decodedJWT = verifier.verify(token);
        PersonDTO personDTO = peopleService.convertToPersonDTO(peopleService.findByEmail(decodedJWT.getSubject()));
        return new UsernamePasswordAuthenticationToken(personDTO, null, Collections.emptyList());
    }

    //TODO: добавить возможность получать данные человека из JWT-токена

}
