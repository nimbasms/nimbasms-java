package gn.nimba.nimbasms.common;

import java.io.IOException;

public interface Pageable<T> {

    RootResult<T> next() throws IOException;

    RootResult<T> previous() throws IOException;

    RootResult<T> list() throws IOException;

    RootResult<T> list(Integer limit, Integer offset) throws IOException;
}
