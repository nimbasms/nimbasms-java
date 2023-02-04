package gn.nimba.nimbasms.common;

import gn.nimba.nimbasms.NimbaSMSClient;
import gn.nimba.nimbasms.exception.NimbaSmsException;
import okhttp3.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static gn.nimba.nimbasms.utils.JsonParser.convertObjectToJsonString;
import static gn.nimba.nimbasms.utils.JsonParser.deserializeJsonString;
import static okhttp3.RequestBody.create;

public class ApiBase {

    private static final String CONTENT_TYPE = "application/json";
    private static final String AUTHORIZATION = "AUTHORIZATION";

    protected static final String BASE_URL = "https://api.nimbasms.com/v1/";

    protected String next;
    protected String previous;
    protected int count;
    protected NimbaSMSClient root;

    public ApiBase(NimbaSMSClient root) {
        this.root = root;
        this.next = null;
        this.previous = null;
        this.count = 0;
    }

    protected <T> RootResult<T> requestMessage(String uri, Map<String, String> params) throws IOException {
        RootResult<T> response = executeGet(uri, params);
        if (Objects.nonNull(response)) {
            this.next = response.getNext();
            this.previous = response.getPrevious();
            this.count = response.getCount();
        }
        return response;
    }
    private <T> T executeGet(String uri, Map<String, String> queryParams) throws IOException {
        Request request = new Request.Builder()
                .headers(createAuthHeaders(root.getToken()))
                .url(buildUrl(uri ,queryParams, null))
                .build();

        return fetchObject(request, (Class<T>) RootResult.class);
    }
    protected  <T> T executeGet(UriType uriType, List<String> pathParams, Class<T> clazz) throws IOException {
        Request request = new Request.Builder()
                .headers(createAuthHeaders(root.getToken()))
                .url(buildUrl(BASE_URL.concat(uriType.getPath()), null, pathParams))
                .build();

        return fetchObject(request, clazz);
    }

    protected   <T> T executePost(UriType uriType, Object object, Class<T> clazz) throws IOException {

        Request request = new Request.Builder()
                .headers(createAuthHeaders(root.getToken()))
                .url(BASE_URL.concat(uriType.getPath()))
                .post(create(MediaType.get(CONTENT_TYPE), convertObjectToJsonString(object)))
                .build();

        return fetchObject(request, clazz);

    }

    private  <T> T fetchObject(Request request, Class<T> clazz) throws IOException {
        Response response = new OkHttpClient().newCall(request).execute();
        handleErrorResponse(response);
        return deserializeJsonString(Objects.requireNonNull(response.body()).string(), clazz);
    }

    /**
     * Handles the error response by extracting the error message and throwing an exception
     *
     * @param response the response object
     * @throws IOException if an IO error occurs
     */
    private void handleErrorResponse(Response response) throws IOException {
        if (!response.isSuccessful()) {
            throw new NimbaSmsException(Objects.requireNonNull(response.body()).string());
        }
    }

    /**
     * Create headers with Authorization token
     * @param token  the token to be added to the headers
     * @return the headers object
     */
    private Headers createAuthHeaders(String token) {
        return new Headers.Builder().add(AUTHORIZATION, token).build();
    }

    /**
     * Builds the url with given query and path parameters
     *
     * @param url         the base url
     * @param queryParams the query parameters to be added
     * @param pathParams  the path parameters to be added
     * @return the final url
     */
    private String buildUrl(String url, Map<String, String> queryParams, List<String> pathParams) {
        HttpUrl.Builder urlBuilder = Objects.requireNonNull(HttpUrl.parse(url)).newBuilder();
        if (queryParams != null) {
            queryParams.forEach(urlBuilder::addQueryParameter);
        }
        if (pathParams != null && !pathParams.isEmpty()) {
            pathParams.forEach(urlBuilder::addPathSegment);
        }

        return urlBuilder.build().toString();
    }

    /**
     * Creates a query parameter map with the specified limit and offset.
     * If limit is null, the default limit of 20 will be used.
     * If offset is null, the default offset of 0 will be used.
     *
     * @param limit The maximum number of results to return.
     * @param offset The number of results to skip.
     * @return A map containing the limit and offset as keys and their corresponding values as strings.
     */
    protected Map<String, String> createPaginationQueryParams(Integer limit, Integer offset) {
        validatePaginationParams(limit, offset);
        return Map.of("limit", String.valueOf(limit), "offset", String.valueOf(offset));
    }

    protected void validatePaginationParams(Integer limit, Integer offset) {
        if (limit == null || limit < 0) {
            throw new NimbaSmsException("Limit must be a positive Integer");
        }
        if (offset == null || offset < 0) {
            throw new NimbaSmsException("Offset must be greater than 1");
        }
    }
}
