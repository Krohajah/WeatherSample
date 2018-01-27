package ru.mamsy.api.model;

import java.util.List;
import java.util.Map;

/**
 * Обработчик ошибок API.
 *
 * @author Maxim Berezin
 */
public class ApiError {

    /**
     * Код результата
     */
    private String result;
    /**
     * Сообщения для пользователя.
     */
    private List<String> messages;
    /**
     * Список общих ошибок
     */
    private List<String> errors;
    /**
     * Список ошибок параметров
     */
    private Map<String, String> fieldErrors;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
