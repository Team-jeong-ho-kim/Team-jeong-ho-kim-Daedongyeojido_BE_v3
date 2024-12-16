package org.example.daedongyeojido_be.infrastructure.feign;

import feign.Response;
import feign.RetryableException;
import feign.codec.ErrorDecoder;
import org.example.daedongyeojido_be.infrastructure.feign.exception.FeignBadRequestException;
import org.example.daedongyeojido_be.infrastructure.feign.exception.FeignForbiddenException;
import org.example.daedongyeojido_be.infrastructure.feign.exception.FeignUnauthorizedException;

public class CustomErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response){
        var exception = errorDecoder.decode(methodKey, response);

        if(response != null && response.status() >= 400) {
            switch (response.status()) {
                case 400:
                    return new FeignBadRequestException();
                case 401:
                    return new FeignUnauthorizedException();
                case 403:
                    return new FeignForbiddenException();
                default:
                    if (response.status() >= 500) {
                        return new RetryableException(
                                response.status(),
                                exception.getMessage(),
                                response.request().httpMethod(),
                                exception,
                                (Long) null,
                                response.request()
                                );
                    }
                    break;
            }

        }
        return exception;
    }
}
