package org.gallery.backend.jwt;


import io.jsonwebtoken.*;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtServiceImpl implements JwtService {

    // 보안키 이고, 외부에 노출되면 안됨, 최소 512 bits 이상
    private String secretKey = "asdfujwk@@ZX5$33$@568ssf12312312312421241241241241231231231//,djw";

    @Override
    public String getToken(String key, Object value) {

        Date expTime = new Date();
        // 1000ms * 60s * 5m
        expTime.setTime(expTime.getTime() + 1000*60*5);
        // secretKey를 byte 배열로
        byte[] secretByteKey = DatatypeConverter.parseBase64Binary(secretKey);
        Key signKey = new SecretKeySpec(secretByteKey, SignatureAlgorithm.HS256.getJcaName());

        Map<String, Object> headerMap = new HashMap<>();
        headerMap.put("typ", "JWT");
        headerMap.put("alg", "HS256");

        Map<String, Object> map = new HashMap<>();
        map.put(key, value);

        JwtBuilder builder = Jwts.builder().setHeader(headerMap)
                .setClaims(map)
                .setExpiration(expTime)
                .signWith(signKey, SignatureAlgorithm.HS256);

        return builder.compact();
    }

    @Override
    public Claims getClaims(String token) {
        if(token != null && !"".equals(token)) {
            try{
                byte[] secretByteKey = DatatypeConverter.parseBase64Binary(secretKey);
                Key signKey = new SecretKeySpec(secretByteKey, SignatureAlgorithm.HS256.getJcaName());
                Claims claims = Jwts.parserBuilder().setSigningKey(signKey).build().parseClaimsJws(token).getBody();
                return claims;
            }
            catch(ExpiredJwtException e){
                // 토큰이 만료되었을 때
            }
            catch (JwtException e){
                // Jwt가 유효하지 않을 때
            }
        }

        return null;
    }
}
