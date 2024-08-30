package us.hgmtrebing.auswendigserver.rest.schemas;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

public class HttpApiResponse<T> extends ResponseEntity<ApiResponse<T>> {

    public HttpApiResponse(ApiResponse<T> body, MultiValueMap<String, String> headers, int rawStatus) {
        super(body, headers, rawStatus);
    }

    public HttpApiResponse(ApiResponse<T> body, MultiValueMap<String, String> headers, HttpStatusCode statusCode) {
        super(body, headers, statusCode);
    }

    public HttpApiResponse(ApiResponse<T> body, HttpStatusCode status) {
        super(body, status);
    }

    public HttpApiResponse(MultiValueMap<String, String> headers, HttpStatusCode status) {
        super(headers, status);
    }

    public HttpApiResponse(HttpStatusCode status) {
        super(status);
    }

    public static <T> HttpApiResponse<T> of (HttpStatusCode code, ApiResponse<T> body) {
        return new HttpApiResponse<>(body, code);
    }

    public static <T> HttpApiResponse<T> of(HttpStatusCode code, ApiStatus status, T data, String ... errors) {
        return of(code, ApiResponse.of(data, status, errors));
    }

    public static <T> HttpApiResponse<T> passedFully(T data, String ... errors) {
        return of(HttpStatus.OK, ApiStatus.PASSED_COMPLETELY, data, errors);
    }

}
