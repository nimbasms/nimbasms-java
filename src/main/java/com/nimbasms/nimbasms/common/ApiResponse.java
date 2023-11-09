package com.nimbasms.nimbasms.common;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ApiResponse<T> {
    private Integer count;
    private String next;
    private String previous;
    private List<T> results;
}
