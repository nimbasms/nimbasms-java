package com.nimbasms.nimbasms.accounts;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class AccountResponse {
    private String sid;
    private Integer balance;

    @JsonProperty("_links")
    private List<Link> links;
}
