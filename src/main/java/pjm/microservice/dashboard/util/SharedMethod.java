package pjm.microservice.dashboard.util;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pjm.microservice.dashboard.model.Metadata;
import pjm.microservice.dashboard.model.Response;
import pjm.microservice.dashboard.model.Result;

import java.util.List;

public class SharedMethod {
    public static ResponseEntity<Result<Object>> getResponse(HttpStatus httpStatus, String message) {
        Result<Object> result = new Result<>();
        Metadata metadata = new Metadata();
        metadata.setCode(httpStatus.value());
        metadata.setMessage(message);
        result.setMetadata(metadata);
        return new ResponseEntity<Result<Object>>(result, httpStatus);
    }

    public static <T> ResponseEntity<Result<T>> getResponse(HttpStatus httpStatus, String message, T T) {
        Result<T> result = new Result<>();
        Metadata metadata = new Metadata();
        metadata.setCode(httpStatus.value());
        metadata.setMessage(message);
        result.setMetadata(metadata);
        Response<T> response = new Response<>();
        response.setData(T);
        result.setResponse(response);
        return new ResponseEntity<Result<T>>(result, httpStatus);
    }

    public static <T> ResponseEntity<Result<T>> getResponse(HttpStatus httpStatus, String message, List<T> T) {
        Result<T> result = new Result<>();
        Metadata metadata = new Metadata();
        metadata.setCode(httpStatus.value());
        metadata.setMessage(message);
        result.setMetadata(metadata);
        Response<T> response = new Response<>();
        response.setList(T);
        result.setResponse(response);
        return new ResponseEntity<Result<T>>(result, httpStatus);
    }
}
