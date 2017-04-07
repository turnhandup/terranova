package myapp.services.utils;

import myapp.pojo.Response;
import org.springframework.stereotype.Component;

/**
 * Created by PANNA on 06.04.2017.
 */
@Component
public class ResponseFactory {

    public <T> Response<T> get(T t){
        Response<T> response = new Response<T>();
        response.setResult(t);
        return response;
    }

}