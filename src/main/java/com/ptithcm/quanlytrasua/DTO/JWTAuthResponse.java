package com.ptithcm.quanlytrasua.DTO;

public class JWTAuthResponse {
    private String accessToken;
    private String username;
    private String password;
    private String maquyen;
    public JWTAuthResponse(){}
    public JWTAuthResponse(String accessToken, String username, String password, String maquyen) {
        this.accessToken = accessToken;
        this.username = username;
        this.password = password;
        this.maquyen = maquyen;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMaquyen() {
        return maquyen;
    }

    public void setMaquyen(String maquyen) {
        this.maquyen = maquyen;
    }
}
