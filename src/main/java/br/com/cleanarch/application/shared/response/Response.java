package br.com.cleanarch.application.shared.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@ToString
public class Response<T> {

    private final int statusCode;
    private final String message;
    final boolean success;
    private final T data;


    private Response(HttpStatus statusCode, String statusDesc, boolean success, T data) {
        this.statusCode = statusCode.value();
        this.message = statusDesc;
        this.success = success;
        this.data = data;

    }

    public static <T> Response<T> failedResponse(HttpStatus statusCode, String message) {
        return new Response<>(statusCode, message, false, null);
    }

    public static <T> Response<T> successResponse(HttpStatus statusCode, String message, T data) {
        return new Response<>(statusCode, message, true, data);
    }

}
