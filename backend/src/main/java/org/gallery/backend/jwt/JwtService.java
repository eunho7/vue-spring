package org.gallery.backend.jwt;

public interface JwtService {
    public String getToken(String key, Object value);
}
