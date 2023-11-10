package com.nimbasms.nimbasms.common;

import com.nimbasms.nimbasms.NimbaSMSClient;
import java.io.IOException;
import java.util.Objects;

public abstract class ApiImplBase<T> extends ApiBase {
    public ApiImplBase(NimbaSMSClient client) {
        super(client);
    }

    public <T> T next() throws IOException {
        if (this.next== null) {
            return null;
        }
        return (T) this.requestMessage(this.next, null, getClassType());
    }

    public <T extends ApiResponse> T previous() throws IOException {
        if (this.previous == null) {
            return null;
        }
        T response = (T) this.requestMessage(this.previous, null, getClassType());
        if (Objects.nonNull(response)) {
            this.next = response.getNext();
            this.previous = response.getPrevious();
            this.count = response.getCount();
        }
        return response;
    }

    public <T extends ApiResponse> T list() throws IOException {
        T response = (T) this.requestMessage(BASE_URL.concat(getUri().getPath()), null, getClassType());
        if (Objects.nonNull(response)) {
            this.next = response.getNext();
            this.previous = response.getPrevious();
            this.count = response.getCount();
        }
        return response;
    }

    public  <T extends ApiResponse>  T list(Integer limit, Integer offset) throws IOException {
        T response = (T) this.requestMessage(
                BASE_URL.concat(getUri().getPath()),
                createPaginationQueryParams(limit, offset),
                getClassType());
        if (Objects.nonNull(response)) {
            this.next = response.getNext();
            this.previous = response.getPrevious();
            this.count = response.getCount();
        }
        return response;
    }

    protected abstract UriType getUri();
    protected abstract Class<T> getClassType();
}
