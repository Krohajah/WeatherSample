package ru.mamsy.weathersample.data.api;

/**
 * @author Maxim Berezin
 */
public class AppStorage {
    /**
     * Токен для дальнейшей работы с API.
     * Пример:5645cd53a0173f22827457cd76674f48.
     */
    private String token;
    /**
     * Id парка.
     */
    private Long parkId;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getParkId() {
        return parkId;
    }

    public void setParkId(Long parkId) {
        this.parkId = parkId;
    }
}
